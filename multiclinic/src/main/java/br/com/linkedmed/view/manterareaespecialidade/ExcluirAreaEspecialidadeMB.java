/**
 * 
 */
package br.com.linkedmed.view.manterareaespecialidade;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.com.linkedmed.business.ManterAreaEspecialidadeBC;
import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.util.FacesBean;

/**
 * Manager Bean que representa a tela de exclusão
 * 
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
@RequiredRole("ManterAreaEspecialidade")
public class ExcluirAreaEspecialidadeMB extends FacesBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1783499682486361572L;
	public static final String NOME_MANAGER_BEAN = "excluirAreaEspecialidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterareaespecialidade/excluirAreaEspecialidade.xhtml";

	private AreaEspecialidade areaEspecialidade = new AreaEspecialidade();
	@Inject
	private ListarAreaEspecialidadeMB listarAreaEspecialidadeMB;
	@Inject
	private ManterAreaEspecialidadeBC manterAreaEspecialidadeBC;

	public AreaEspecialidade getAreaEspecialidade() {
		return areaEspecialidade;
	}

	public void setAreaEspecialidade(AreaEspecialidade areaEspecialidade) {
		this.areaEspecialidade = areaEspecialidade;
	}

	@Transactional
	public String excluir() {
		String retorno = null;

		try {
			manterAreaEspecialidadeBC.excluir(areaEspecialidade);

			List<AreaEspecialidade> lista = manterAreaEspecialidadeBC
					.obterTodos();
			listarAreaEspecialidadeMB.setLista(lista);
			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
			info("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String desistirExcluir() {
		String retorno = null;
		try {
			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
