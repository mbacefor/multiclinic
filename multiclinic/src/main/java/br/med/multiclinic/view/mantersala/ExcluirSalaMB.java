package br.med.multiclinic.view.mantersala;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import br.med.multiclinic.domain.Equipamento;
import br.med.multiclinic.domain.Sala;
import br.med.multiclinic.util.FacesBean;


@ManagedBean(name = "excluirSalaMB")
@SessionScoped
public class ExcluirSalaMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "excluirSalaMB";
	public static final String CAMINHO_TELA = "/pages/mantersala/excluirSala.xhtml";

	
	private Sala sala = new Sala();
	
	private DualListModel<Equipamento> equipamentos;

	public void popularDualListModel(List<Equipamento> source,
			List<Equipamento> target) {
		source.removeAll(target);
		setEquipamentos(new DualListModel<Equipamento>(source,
				target));
	}
	

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String excluir() {
		String retorno = null;
		try {
//			ManterSalaControle.getInstance().excluir(sala);
//			ListarSalaMB listarSalaMB = (ListarSalaMB) getBean(ListarSalaMB.NOME_MANAGER_BEAN);
//			List<Sala> lista = ManterSalaControle.getInstance()
//				.obterTodos();
//			listarSalaMB.setLista(lista);
//			retorno = ListarSalaMB.CAMINHO_TELA;
			info("Exclusão realizada com sucesso!");
		
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String desistirExcluir(){
		String retorno = null;
		try {
			retorno = ListarSalaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}


	public DualListModel<Equipamento> getEquipamentos() {
		return equipamentos;
	}


	public void setEquipamentos(DualListModel<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
}

