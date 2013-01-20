package br.med.multiclinic.view.mantersala;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import br.med.multiclinic.domain.Equipamento;
import br.med.multiclinic.domain.Sala;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

@ManagedBean(name = "editarSalaMB")
@SessionScoped
public class EditarSalaMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "editarSalaMB";
	public static final String CAMINHO_TELA = "/pages/mantersala/editarsala.xhtml";

	private Sala sala = new Sala();
	private DualListModel<Equipamento> equipamentosDualList;

	public String prepararNovo() {
		String retorno = null;
		try {

//			List<Equipamento> listaTodosEquipamento = ManterEquipamentoControle
//					.getInstance().obterTodos();
//
//			Sala novaSala = new Sala();
//			novaSala.setEquipamentos(new ArrayList<Equipamento>());
//			prepararPickList(listaTodosEquipamento, novaSala.getEquipamentos());
//
//			EditarSalaMB editarSalaMB = (EditarSalaMB) getBean(EditarSalaMB.NOME_MANAGER_BEAN);
//			editarSalaMB.setSala(novaSala);
			retorno = EditarSalaMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public void prepararPickList(List<Equipamento> source,
			List<Equipamento> target) {
		source.removeAll(target);
		equipamentosDualList = new DualListModel<Equipamento>(source, target);
	}

	public String salvar() {
		String retorno = null;
		try {
//			ManterSalaControle controle = ManterSalaControle.getInstance();
//			Usuario usuarioLogado = obterUsuarioLogado();
//			sala.setEquipamentos(getEquipamentosDualList().getTarget());
//			controle.salvar(sala, usuarioLogado);
//			ListarSalaMB listarSalaMB = (ListarSalaMB) getBean(ListarSalaMB.NOME_MANAGER_BEAN);
//			List<Sala> lista = controle.obterTodos();
//			listarSalaMB.setLista(lista);
//			retorno = ListarSalaMB.CAMINHO_TELA;
			info("Sala salva com sucesso! ID = " + this.getSala().getId());

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String cancelar() {
		String retorno = null;
		try {
			retorno = EditarSalaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public DualListModel<Equipamento> getEquipamentosDualList() {
		return equipamentosDualList;
	}

	public void setEquipamentosDualList(
			DualListModel<Equipamento> equipamentosDualList) {
		this.equipamentosDualList = equipamentosDualList;
	}
}
