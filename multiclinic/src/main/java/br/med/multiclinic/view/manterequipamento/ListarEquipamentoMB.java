/**
 * 
 */
package br.med.multiclinic.view.manterequipamento;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.Equipamento;
import br.med.multiclinic.util.FacesBean;


/**
 * Manager Bean associado a tela de listar equipamentos
 * @author fa7bd
 *
 */

@ManagedBean(name = "listarEquipamentoMB")
@SessionScoped

public class ListarEquipamentoMB extends FacesBean{
	
	public static final String NOME_MANAGER_BEAN = "listarEquipamentoMB";
	public static final String CAMINHO_TELA = "/pages/manterequipamento/listarEquipamento.xhtml";
	
	/*
	 * Representa a lista de equipamentos
	 */
	
	private List<Equipamento> lista = new ArrayList<Equipamento>();
	
	/*
	 * Atributo que representa o objeto que esta sendo editado ou excluido
	 */
		
	private Equipamento entidadeCorrente = null;
	

	/**
	 * Metodo que inicia a listagem de equipamento
	 * 
	 * @return
	 */
	public String prepararListar() {
		String retorno = null;
		try {
		//	setLista(ManterEquipamentoControle.getInstance().obterTodos());
			retorno = ListarEquipamentoMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
	
	public String prepararEditar(){
		String retorno = null;
		try {
			
			EditarEquipamentoMB editarEquipamentoMB = (EditarEquipamentoMB) getBean(EditarEquipamentoMB.NOME_MANAGER_BEAN);
			editarEquipamentoMB.setEquipamento(entidadeCorrente);		
			retorno = EditarEquipamentoMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
	
	/**
	 * Metodo que inicia a listagem de equipamento
	 * 
	 * @return
	 */
	public String prepararExcluir() {
		String retorno = null;
		try {
			ExcluirEquipamentoMB excluirEquipamentoMB = (ExcluirEquipamentoMB) getBean(ExcluirEquipamentoMB.NOME_MANAGER_BEAN);
			excluirEquipamentoMB.setEquipamento(entidadeCorrente);
			warn("Deseja realmente excluir o registro?");
			retorno = ExcluirEquipamentoMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
	
	public List<Equipamento> getLista() {
		return lista;
	}

	public void setLista(List<Equipamento> lista) {
		this.lista = lista;
	}


	public Equipamento getEntidadeCorrente() {
		return entidadeCorrente;
	}


	public void setEntidadeCorrente(Equipamento entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

}
