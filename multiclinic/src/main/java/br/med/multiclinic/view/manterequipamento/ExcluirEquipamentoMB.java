/**
 * 
 */
package br.med.multiclinic.view.manterequipamento;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.Equipamento;
import br.med.multiclinic.util.FacesBean;


/**
 * Manager Bean associado a tela de excluir dos equipamentos
 * @author fa7bd
 *
 */

@ManagedBean(name = "excluirEquipamentoMB")
@SessionScoped
public class ExcluirEquipamentoMB extends FacesBean{
	public static final String NOME_MANAGER_BEAN = "excluirEquipamentoMB";
	public static final String CAMINHO_TELA = "/pages/manterequipamento/excluirEquipamento.xhtml";

	private Equipamento equipamento = new Equipamento();

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public String excluir() {
		String retorno = null;

		try {
//			ManterEquipamentoControle.getInstance().excluir(equipamento);
//			ListarEquipamentoMB listarEquipamentoMB = (ListarEquipamentoMB) getBean(ListarEquipamentoMB.NOME_MANAGER_BEAN);
//			List<Equipamento> lista = ManterEquipamentoControle.getInstance().obterTodos();
//			listarEquipamentoMB.setLista(lista);
//			retorno = ListarEquipamentoMB.CAMINHO_TELA;
//			info("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String desistirExcluir() {
		String retorno = null;
		try {
			retorno = ListarEquipamentoMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
