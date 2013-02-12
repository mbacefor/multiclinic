/**
 * 
 */
package br.med.multiclinic.view.manterpaciente;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.PacienteBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Paciente;
import br.med.multiclinic.util.FacesBean;

/**
 * Classe que representa a tela EditarUsuario.xhtml
 * 
 * @author mbacefor
 * 
 */
@ViewController
@javax.enterprise.context.SessionScoped
public class ListarPaciente extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "listarPaciente";
	public static final String CAMINHO_TELA = "/pages/manterpaciente/listarPaciente.xhtml";

	/*
	 * Representa a lista de entidades
	 */
	private List<Paciente> lista = new ArrayList<Paciente>();

	@Inject
	private PacienteBC pacienteBC;

	/**
	 * Representa a entidade selecionada
	 */
	private Paciente entidadeCorrente = new Paciente();

	public ListarPaciente() {

	}

	public String prepararEditar() {
		String retorno = null;

		try {
			EditarPacienteMB editarPaciente = (EditarPacienteMB) getBean(EditarPacienteMB.NOME_MANAGER_BEAN);
			editarPaciente.setPaciente(entidadeCorrente);
			retorno = EditarPacienteMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararExcluir() {
		String retorno = null;

		try {
			ExcluirPaciente editarPaciente = (ExcluirPaciente) getBean(ExcluirPaciente.NOME_MANAGER_BEAN);
			editarPaciente.setPaciente(entidadeCorrente);
			info("Usuário selecionado Confirme a exclusão!");
			retorno = ExcluirPaciente.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	public String prepararNovo() {
		String retorno = null;

		try {
			Paciente novo = new Paciente();
			EditarPacienteMB editarPaciente = (EditarPacienteMB) getBean(EditarPacienteMB.NOME_MANAGER_BEAN);
			editarPaciente.setPaciente(novo);
			editarPaciente.setEmailUsuario(null);
			info("Entre com os dados do usuário!");
			retorno = EditarPacienteMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	public String prepararListar() {
		String retorno = null;

		try {
			List<Paciente> lista = pacienteBC.obterTodos();
			setLista(lista);
			retorno = CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	/**
	 * @return the entidadeCorrente
	 */
	public Paciente getEntidadeCorrente() {
		return entidadeCorrente;
	}

	/**
	 * @param entidadeCorrente
	 *            the entidadeCorrente to set
	 */
	public void setEntidadeCorrente(Paciente entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

	/**
	 * @return the lista
	 */
	public List<Paciente> getLista() {
		return lista;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	public void setLista(List<Paciente> lista) {
		this.lista = lista;
	}

}