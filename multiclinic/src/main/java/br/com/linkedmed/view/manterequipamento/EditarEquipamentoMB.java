/**
 * 
 */
package br.com.linkedmed.view.manterequipamento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.linkedmed.domain.Clinica;
import br.com.linkedmed.domain.Equipamento;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;


/**
 * Manager Bean associado a tela de edição dos equipamentos
 * 
 * @author fa7bd
 */

@ManagedBean(name = "editarEquipamentoMB")
@SessionScoped
public class EditarEquipamentoMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "editarEquipamentoMB";
	public static final String CAMINHO_TELA = "/pages/manterequipamento/editarEquipamento.xhtml";
	/*
	 * Atributo conterá as informações dos equipamentos
	 */
	private Equipamento equipamento = new Equipamento();
	
	private List<Clinica> clinicasCadastradas;

	/**
	 * Metodo que inicia o novo equipamento, direciona para pagina de destino se
	 * for tudo ok "retorno = EditarEquipamentoMB.CAMINHO_TELA;" se tiver
	 * errror vai retornar para pagina "error (e.getMessage());"
	 * 
	 * @return
	 */
	/**
	 * Metodo que inicia o novo equipamento
	 * 
	 * @return
	 */
	
	private List<SelectItem> listaClinicasSelectItem;
	
	public String prepararNovo() {
		
		String retorno = null;
		
		try {
////			ManterClinicaControle clinicaControle = ManterClinicaControle
////					.getInstance();
////			List<Clinica> listaClinicas = clinicaControle.obterTodos();
////			listaClinicasSelectItem = new ArrayList<SelectItem>();
////			for (Iterator iterator = listaClinicas.iterator(); iterator
////					.hasNext();) {
////				Clinica clinica = (Clinica) iterator.next();
////				listaClinicasSelectItem.add(new SelectItem(clinica, clinica
////						.getNome()));
//			}

		} catch (Exception e) {
			error(e.getMessage());
		}
		
		try {
			Equipamento novoEquipamento = new Equipamento();
			EditarEquipamentoMB editarEquipamentoMB = (EditarEquipamentoMB) getBean(EditarEquipamentoMB.NOME_MANAGER_BEAN);
			editarEquipamentoMB.setEquipamento(novoEquipamento);
			retorno = EditarEquipamentoMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}


	/**
	 * Metodo que salva um equipamento
	 * 
	 * @return
	 */
	public String salvar() {
		String retorno = null;
		try {

//			ManterEquipamentoControle controle = ManterEquipamentoControle.getInstance();
//			Usuario usuarioLogado = obterUsuarioLogado();
//			controle.salvar(equipamento, usuarioLogado);
//			ListarEquipamentoMB listarEquipamentoMB = (ListarEquipamentoMB) getBean(ListarEquipamentoMB.NOME_MANAGER_BEAN);
//			List<Equipamento> lista = controle.obterTodos();
//			listarEquipamentoMB.setLista(lista);
//			retorno = ListarEquipamentoMB.CAMINHO_TELA;
			info("Equipamento salvo com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}


	/**
	 * Metodo para cancelar
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = ListarEquipamentoMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento){
		this.equipamento = equipamento;
	}


	public List<Clinica> getClinicasCadastradas() {
		return clinicasCadastradas;
	}


	public void setClinicasCadastradas(List<Clinica> clinicasCadastradas) {
		this.clinicasCadastradas = clinicasCadastradas;
	}
}
