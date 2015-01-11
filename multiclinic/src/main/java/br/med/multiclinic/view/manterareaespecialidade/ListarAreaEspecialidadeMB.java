/**
 * 
 */
package br.med.multiclinic.view.manterareaespecialidade;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterAreaEspecialidadeBC;
import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.util.FacesBean;

/**
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
@RequiredRole("ManterAreaEspecialidade")
public class ListarAreaEspecialidadeMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "listarAreaEspecialidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterareaespecialidade/listarAreaEspecialidade.xhtml";

	private List<AreaEspecialidade> lista = new ArrayList<AreaEspecialidade>();

	@Inject
	ManterAreaEspecialidadeBC manterAreaEspecialidadeBC;
	@Inject
	EditarAreaEspecialidadeMB editarAreaEspecialidadeMB;
	@Inject
	ExcluirAreaEspecialidadeMB excluirAreaEspecialidadeMB;

	private AreaEspecialidade entidadeCorrente = null;

	public String prepararListar() {
		String retorno = null;
		try {
			setLista(manterAreaEspecialidadeBC.obterTodos());
			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararEditar() {
		String retorno = null;
		try {
			editarAreaEspecialidadeMB.setAreaEspecialidade(entidadeCorrente);
			retorno = EditarAreaEspecialidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararExcluir() {
		String retorno = null;
		try {
			excluirAreaEspecialidadeMB.setAreaEspecialidade(entidadeCorrente);
			warn("Deseja realmente excluir o registro?");
			retorno = ExcluirAreaEspecialidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public List<AreaEspecialidade> getLista() {
		return lista;
	}

	public void setLista(List<AreaEspecialidade> lista) {
		this.lista = lista;
	}

	public AreaEspecialidade getEntidadeCorrente() {
		return entidadeCorrente;
	}

	public void setEntidadeCorrente(AreaEspecialidade entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

}
