/**
 * 
 */
package br.med.multiclinic.view.manterareaespecialidade;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterAreaEspecialidadeBC;
import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

/**
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
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

	public String prepararNovo() {
		String retorno = null;

		try {
			AreaEspecialidade novoAreaEspecialidade = new AreaEspecialidade();
			EditarAreaEspecialidadeMB editarAreaEspecialidadeMB = (EditarAreaEspecialidadeMB) getBean(EditarAreaEspecialidadeMB.NOME_MANAGER_BEAN);
			editarAreaEspecialidadeMB
					.setAreaEspecialidade(novoAreaEspecialidade);
			retorno = EditarAreaEspecialidadeMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String salvar() {
		String retorno = null;

		try {

			Usuario usuarioLogado = obterUsuarioLogado();
			manterAreaEspecialidadeBC.salvar(areaEspecialidade, usuarioLogado);
			ListarAreaEspecialidadeMB listarAreaEspecialidadeMB = (ListarAreaEspecialidadeMB) getBean(ListarAreaEspecialidadeMB.NOME_MANAGER_BEAN);
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
			
			ListarAreaEspecialidadeMB listarAreaEspecialidadeMB = (ListarAreaEspecialidadeMB) getBean(ListarAreaEspecialidadeMB.NOME_MANAGER_BEAN);
			List<AreaEspecialidade> lista = manterAreaEspecialidadeBC.obterTodos();
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
