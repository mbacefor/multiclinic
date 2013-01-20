/**
 * 
 */
package br.med.multiclinic.view.manterareaespecialidade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.util.FacesBean;

/**
 * @author fa7bd
 * 
 */

@ManagedBean(name = "listarAreaEspecialidadeMB")
@SessionScoped
public class ListarAreaEspecialidadeMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "listarAreaEspecialidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterareaespecialidade/listarAreaEspecialidade.xhtml";

	private List<AreaEspecialidade> lista = new ArrayList<AreaEspecialidade>();
	
	private AreaEspecialidade entidadeCorrente = null;
	
	public ListarAreaEspecialidadeMB(){
		super();
	}
	
	

	public String prepararListar() {
		String retorno = null;
		try {
			//setLista(ManterAreaEspecialidadeControle.getInstance().obterTodos());
			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
	
	public String prepararEditar() {
		String retorno = null;
		try {
			EditarAreaEspecialidadeMB editarAreaEspecialidadeMB = (EditarAreaEspecialidadeMB) getBean(EditarAreaEspecialidadeMB.NOME_MANAGER_BEAN);
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
			ExcluirAreaEspecialidadeMB excluirAreaEspecialidadeMB = (ExcluirAreaEspecialidadeMB) getBean(ExcluirAreaEspecialidadeMB.NOME_MANAGER_BEAN);
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
