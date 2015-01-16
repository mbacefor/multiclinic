/**
 * 
 */
package br.com.linkedmed.view.manterareaespecialidade;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.com.linkedmed.business.ManterAreaEspecialidadeBC;
import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;

/**
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
@RequiredRole("ManterAreaEspecialidade")
public class EditarAreaEspecialidadeMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "editarAreaEspecialidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterareaespecialidade/editarAreaEspecialidade.xhtml";

	private AreaEspecialidade areaEspecialidade = new AreaEspecialidade();
	@Inject
	private ManterAreaEspecialidadeBC manterAreaEspecialidadeBC;
	@Inject
	private ListarAreaEspecialidadeMB listarAreaEspecialidadeMB;
	@Inject
	private EditarAreaEspecialidadeMB editarAreaEspecialidadeMB;

	public String prepararNovo() {
		String retorno = null;

		try {
			AreaEspecialidade novoAreaEspecialidade = new AreaEspecialidade();
			editarAreaEspecialidadeMB
					.setAreaEspecialidade(novoAreaEspecialidade);
			retorno = EditarAreaEspecialidadeMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	@Transactional
	public String salvar() {
		String retorno = null;

		try {

			Usuario usuarioLogado = obterUsuarioLogado();
			manterAreaEspecialidadeBC.salvar(areaEspecialidade, usuarioLogado);
			List<AreaEspecialidade> lista = manterAreaEspecialidadeBC
					.obterTodos();
			listarAreaEspecialidadeMB.setLista(lista);
			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
			info("Area de Especialidade salva com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String cancelar() {
		String retorno = null;

		try {

			List<AreaEspecialidade> lista = manterAreaEspecialidadeBC
					.obterTodos();
			listarAreaEspecialidadeMB.setLista(lista);
			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public AreaEspecialidade getAreaEspecialidade() {
		return areaEspecialidade;
	}

	public void setAreaEspecialidade(AreaEspecialidade areaEspecialidade) {
		this.areaEspecialidade = areaEspecialidade;
	}
}
