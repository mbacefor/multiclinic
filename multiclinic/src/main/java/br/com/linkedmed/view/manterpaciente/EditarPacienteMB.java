/**
 * 
 */
package br.com.linkedmed.view.manterpaciente;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.com.linkedmed.business.PacienteBC;
import br.com.linkedmed.domain.Paciente;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;

@ViewController
@javax.enterprise.context.SessionScoped
public class EditarPacienteMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "editarPacienteMB";
	public static final String CAMINHO_TELA = "/pages/manterpaciente/editarPaciente.xhtml";
	private Paciente pessoa = new Paciente();
	private String emailUsuario;

	@Inject
	private PacienteBC pacienteBC;
	@Inject
	private ListarPacienteMB listarPaciente;

	// TODO Implementar validador de CPF

	/**
	 * 
	 */
	public EditarPacienteMB() {
		super();
	}

	/**
	 * Metodo que salva a entidade
	 * 
	 * @return
	 */
	@Transactional
	public String salvar() {
		String retorno = null;

		try {
			Usuario usuarioLogado = obterUsuarioLogado();
			pacienteBC.salvar(pessoa, usuarioLogado);
			List<Paciente> listaPaciente = pacienteBC.obterTodos();
			listarPaciente.setLista(listaPaciente);
			info("Paciente salvo com sucesso");
			retorno = ListarPacienteMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	public String sairSemSalvar() {
		String retorno = null;
		try {
			retorno = ListarPacienteMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
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
		getPessoa().setNomeFoto(photo);
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

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Paciente getPessoa() {
		return pessoa;
	}

	public void setPessoa(Paciente pessoa) {
		this.pessoa = pessoa;
	}

}
