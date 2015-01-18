/**
 * 
 */
package br.com.linkedmed.view.manterpaciente;

import java.util.List;

import javax.inject.Inject;

import br.com.linkedmed.business.PacienteBC;
import br.com.linkedmed.domain.Paciente;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@javax.enterprise.context.SessionScoped
public class ExcluirPaciente extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "excluirPaciente";
	public static final String CAMINHO_TELA = "/pages/manterpaciente/excluirPaciente.xhtml";

	private Paciente paciente = new Paciente();

	@Inject
	PacienteBC pacienteBC;

	/**
	 * Metodo que salva a entidade
	 * 
	 * @return
	 */
	@Transactional
	public String excluir() {
		String retorno = null;

		try {
			pacienteBC.excluir(paciente);
			ListarPaciente listarPaciente = (ListarPaciente) getBean(ListarPaciente.NOME_MANAGER_BEAN);
			List<Paciente> listaPaciente = pacienteBC.findAll();
			listarPaciente.setLista(listaPaciente);
			info("Paciente excluído com sucesso");
			retorno = ListarPaciente.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	public String sairSemExcluir() {
		String retorno = null;
		try {
			retorno = ListarPaciente.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente
	 *            the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
