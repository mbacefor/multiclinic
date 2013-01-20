package br.med.multiclinic.view.mantersala;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.Equipamento;
import br.med.multiclinic.domain.Sala;
import br.med.multiclinic.util.FacesBean;

@ManagedBean(name = "listarSalaMB")
@SessionScoped
public class ListarSalaMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "listarSalaMB";
	public static final String CAMINHO_TELA = "/pages/mantersala/listarSala.xhtml";

	private List<Sala> lista = new ArrayList<Sala>();

	private Sala entidadeCorrente = null;

	public ListarSalaMB() {
		super();

	}

	public List<Sala> getLista() {
		return lista;
	}

	public void setLista(List<Sala> lista) {
		this.lista = lista;
	}

	public String prepararListar() {
		String retorno = null;
		try {
	//		setLista(ManterSalaControle.getInstance().obterTodos());
			retorno = ListarSalaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararEditar() {
		String retorno = null;
		try {
//			List<Equipamento> listaTodosEquipamento = ManterEquipamentoControle
//					.getInstance().obterTodos();
//			EditarSalaMB editarSalaMB = (EditarSalaMB) getBean(EditarSalaMB.NOME_MANAGER_BEAN);
//			editarSalaMB.setSala(entidadeCorrente);
//			editarSalaMB.prepararPickList(listaTodosEquipamento,
//					entidadeCorrente.getEquipamentos());
			retorno = EditarSalaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararExcluir() {
		String retorno = null;
		try {
//			List<Equipamento> listaTodosEquipamento = ManterEquipamentoControle
//					.getInstance().obterTodos();
//			ExcluirSalaMB excluirSalaMB = (ExcluirSalaMB) getBean(ExcluirSalaMB.NOME_MANAGER_BEAN);
//			excluirSalaMB.setSala(entidadeCorrente);
//			excluirSalaMB.popularDualListModel(listaTodosEquipamento,
//					entidadeCorrente.getEquipamentos());
			warn("Deseja realmente excluir o registro?");
			retorno = ExcluirSalaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Sala getEntidadeCorrente() {
		return entidadeCorrente;
	}

	public void setEntidadeCorrente(Sala entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

}
