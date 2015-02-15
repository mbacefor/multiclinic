package br.com.linkedmed.view.manterprofissional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;
import org.primefaces.model.DualListModel;

import br.com.linkedmed.business.ManterAreaEspecialidadeBC;
import br.com.linkedmed.business.ManterProfissionalBC;
import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.domain.Profissional;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@javax.enterprise.context.SessionScoped
public class EditarProfissionalMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "editarProfissionalMB";
	public static final String CAMINHO_TELA = "/pages/manterprofissional/editarProfissional.xhtml";

	private DualListModel<AreaEspecialidade> areasEspecilidades;

	private Profissional pessoa = new Profissional();

	private String emailUsuario;

	@Inject
	private ManterProfissionalBC manterProfissionalBC;

	@Inject
	private ManterAreaEspecialidadeBC manterAreaEspecialidadeBC;

	public void popularDualListModel(List<AreaEspecialidade> source,
			List<AreaEspecialidade> target) {
		source.removeAll(target);
		areasEspecilidades = new DualListModel<AreaEspecialidade>(source,
				target);
	}

	public DualListModel<AreaEspecialidade> getAreasEspecilidades() {
		return areasEspecilidades;
	}

	public void setAreasEspecilidades(
			DualListModel<AreaEspecialidade> areasEspecilidades) {
		this.areasEspecilidades = areasEspecilidades;
	}

	public String prepararNovo() {
		String retorno = null;
		try {
			Profissional novoProfissional = new Profissional();
			EditarProfissionalMB editarProfissionalMB = (EditarProfissionalMB) getBean(EditarProfissionalMB.NOME_MANAGER_BEAN);

			editarProfissionalMB.setPessoa(novoProfissional);

			List<AreaEspecialidade> sourceAreaEspecialidade = manterAreaEspecialidadeBC
					.obterTodos();
			novoProfissional
					.setAreasEspecialidade(new ArrayList<AreaEspecialidade>());

			editarProfissionalMB.popularDualListModel(sourceAreaEspecialidade,
					novoProfissional.getAreasEspecialidade());

			retorno = EditarProfissionalMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo para salvar o Profissional.
	 * 
	 * @return
	 */
	@Transactional
	public String salvar() {
		String retorno = null;
		try {

			Usuario usuarioLogado = obterUsuarioLogado();
			pessoa.setAreasEspecialidade(areasEspecilidades.getTarget());
			manterProfissionalBC.salvar(pessoa, usuarioLogado);

			ListarProfissionalMB listarProfissionalMB = (ListarProfissionalMB) getBean(ListarProfissionalMB.NOME_MANAGER_BEAN);
			List<Profissional> lista = manterProfissionalBC.obterTodos();

			listarProfissionalMB.setLista(lista);
			retorno = ListarProfissionalMB.CAMINHO_TELA;

			info("Profissional cadastrado com sucesso! ");

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela o Profissional.
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = ListarProfissionalMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Profissional getPessoa() {
		return pessoa;
	}

	public void setPessoa(Profissional pessoa) {
		this.pessoa = pessoa;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
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

}
