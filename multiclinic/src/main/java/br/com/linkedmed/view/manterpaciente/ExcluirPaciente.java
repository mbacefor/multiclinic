/**
 * 
 */
package br.com.linkedmed.view.manterpaciente;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.linkedmed.domain.Paciente;
import br.com.linkedmed.util.FacesBean;

@ManagedBean(name = "excluirPaciente")
@SessionScoped
public class ExcluirPaciente extends FacesBean {

	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "excluirPaciente";
	public static final String CAMINHO_TELA = "/pages/manterpaciente/excluirPaciente.xhtml";

	private Paciente paciente = new Paciente();

	/**
	 * 
	 */
	public ExcluirPaciente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que salva a entidade
	 * 
	 * @return
	 */
	public String excluir() {
		String retorno = null;
//		ManterPacienteControle controlador = ManterPacienteControle
//				.getInstance();
//		try {
//			controlador.excluir(paciente);
//			ListarPaciente listarPaciente = (ListarPaciente) getBean(ListarPaciente.NOME_MANAGER_BEAN);
//			List<Paciente> listaPaciente = controlador.obterPaciente();
//			listarPaciente.setLista(listaPaciente);
//			info("Paciente excluído com sucesso");
//			retorno = ListarPaciente.CAMINHO_TELA;
//		} catch (Exception e) {
//			error(e.getMessage());
//		}

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
