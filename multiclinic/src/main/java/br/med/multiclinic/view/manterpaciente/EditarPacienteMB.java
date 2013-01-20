/**
 * 
 */
package br.med.multiclinic.view.manterpaciente;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;

import br.med.multiclinic.domain.Paciente;
import br.med.multiclinic.util.FacesBean;

@ManagedBean(name = "editarPacienteMB")
@SessionScoped
public class EditarPacienteMB extends FacesBean {

	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "editarPacienteMB";
	public static final String CAMINHO_TELA = "/pages/manterpaciente/editarPaciente.xhtml";
	private Paciente paciente = new Paciente();

	// TODO Implementar validador de CPF

	/**
	 * 
	 */
	public EditarPacienteMB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que salva a entidade
	 * 
	 * @return
	 */
	public String salvar() {
		String retorno = null;
//		ManterPacienteControle controlador = ManterPacienteControle
//				.getInstance();
//		try {
//			controlador.salvar(paciente);
//			ListarPaciente listarPaciente = (ListarPaciente) getBean(ListarPaciente.NOME_MANAGER_BEAN);
//			List<Paciente> listaPaciente = controlador.obterPaciente();
//			listarPaciente.setLista(listaPaciente);
//			info("Paciente salvo com sucesso");
//			retorno = ListarPaciente.CAMINHO_TELA;
//		} catch (Exception e) {
//			error(e.getMessage());
//		}
//
		return retorno;
	}

	public String sairSemSalvar() {
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

	/**
	 * Metodo para capturar a foto
	 */
	private List<String> photos = new ArrayList<String>();

	private String getRandomImageName() {
		int i = (int) (Math.random() * 10000000);

		return String.valueOf(i);
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void oncapture(CaptureEvent captureEvent) {
		String photo = getRandomImageName();
		this.photos.add(0, photo);
		byte[] data = captureEvent.getData();
		getPaciente().setNomeFoto(photo);
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String newFileName = servletContext.getRealPath("") + File.separator
				+ "photocam" + File.separator + photo + ".png";

		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(new File(newFileName));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
		} catch (Exception e) {
			throw new FacesException("Error in writing captured image.");
		}
	}

}
