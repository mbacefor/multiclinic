/**
 * 
 */
package br.med.multiclinic.view.manterconvenio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.domain.Convenio;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean associado a tela de edição do convenio
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "listarConvenioMB")
@SessionScoped
public class ListarConvenioMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "listarConvenioMB";
	public static final String CAMINHO_TELA = "/pages/manterconvenio/listarConvenio.xhtml";
	/**
	 * Representa a lista de convenios
	 */
	private List<Convenio> lista = new ArrayList<Convenio>();

	/*
	 * Atributo que representa o objeto que esta senod editado ou excluído
	 */
	private Convenio entidadeCorrente = null;

	public ListarConvenioMB() {
		super();

	}

	public List<Convenio> getLista() {
		return lista;
	}

	public void setLista(List<Convenio> lista) {
		this.lista = lista;
	}

	/**
	 * Metodo que inicia a listagem de convenio
	 * 
	 * @return
	 */
	public String prepararListar() {
		String retorno = null;
		try {
	//		setLista(ManterConvenioControle.getInstance().obterTodos());
			retorno = ListarConvenioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que inicia a listagem de convenio
	 * 
	 * @return
	 */
	public String prepararEditar() {
		String retorno = null;
		try {

			// Obter Todos as areas de especilidades
//			List<AreaEspecialidade> sourceAreaEspecialidade = ManterAreaEspecialidadeControle
//					.getInstance().obterTodos();
//
//			EditarConvenioMB editarConvenioMB = (EditarConvenioMB) getBean(EditarConvenioMB.NOME_MANAGER_BEAN);
//			editarConvenioMB.setConvenio(entidadeCorrente);
//
//			editarConvenioMB.popularDualListModel(sourceAreaEspecialidade,
//					entidadeCorrente.getAreasEspecialidade());

			retorno = EditarConvenioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que inicia a listagem de convenio
	 * 
	 * @return
	 */
	public String prepararExcluir() {
		String retorno = null;
		try {
			// Obter Todos as areas de especilidades
//			List<AreaEspecialidade> sourceAreaEspecialidade = ManterAreaEspecialidadeControle
//					.getInstance().obterTodos();
//
//			ExcluirConvenioMB excluirConvenioMB = (ExcluirConvenioMB) getBean(ExcluirConvenioMB.NOME_MANAGER_BEAN);
//			excluirConvenioMB.setConvenio(entidadeCorrente);
//			excluirConvenioMB.popularDualListModel(sourceAreaEspecialidade,
//					entidadeCorrente.getAreasEspecialidade());
			warn("Deseja realmente excluir o registro?");
			retorno = ExcluirConvenioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Convenio getEntidadeCorrente() {
		return entidadeCorrente;
	}

	public void setEntidadeCorrente(Convenio entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

	/**
	 * Metodo que inicia o novo convenio
	 * 
	 * @return
	 */
	public String prepararNovo() {
		String retorno = null;
		try {
			Convenio novoConvenio = new Convenio();
			EditarConvenioMB editarConvenioMB = (EditarConvenioMB) getBean(EditarConvenioMB.NOME_MANAGER_BEAN);
			editarConvenioMB.setConvenio(novoConvenio);

			// Obter Todos as areas de especilidades
//			List<AreaEspecialidade> sourceAreaEspecialidade = ManterAreaEspecialidadeControle
//					.getInstance().obterTodos();
//			novoConvenio
//					.setAreasEspecialidade(new ArrayList<AreaEspecialidade>());
//
//			editarConvenioMB.popularDualListModel(sourceAreaEspecialidade,
//					novoConvenio.getAreasEspecialidade());
//
			retorno = EditarConvenioMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}