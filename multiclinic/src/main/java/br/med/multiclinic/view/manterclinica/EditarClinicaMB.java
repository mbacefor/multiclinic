/**
 * 
 */
package br.med.multiclinic.view.manterclinica;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.domain.Clinica;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean associado a tela de edição do clínica
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "editarClinicaMB")
@SessionScoped
public class EditarClinicaMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "editarClinicaMB";
	public static final String CAMINHO_TELA = "/pages/manterclinica/editarClinica.xhtml";

	private DualListModel<AreaEspecialidade> areasEspecialidades;

	public void popularDualListModel(List<AreaEspecialidade> source,
			List<AreaEspecialidade> target) {
		source.removeAll(target);
		areasEspecialidades = new DualListModel<AreaEspecialidade>(source,
				target);
	}

	public DualListModel<AreaEspecialidade> getAreasEspecilidades() {
		return areasEspecialidades;
	}

	public void setAreasEspecialidades(
			DualListModel<AreaEspecialidade> areasEspecilidades) {
		this.areasEspecialidades = areasEspecilidades;
	}

	private Clinica clinica = new Clinica();

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	/*
	 * Atributo que conterá as informações das clínicas
	 */

	/**
	 * Metodo que inicia a nova clínica
	 * 
	 * @return
	 */
	public String prepararNovo() {
		String retorno = null;
		try {
			Clinica novaClinica = new Clinica();

			// List<AreaEspecialidade> sourceAreaEspecialidade =
			// ManterAreaEspecialidadeControle
			// .getInstance().obterTodos();
			//
			// //clinica.setAreasEspecialidade(new
			// ArrayList<AreaEspecialidade>());
			//
			// //areasEspecialidades = new DualListModel<AreaEspecialidade>(
			// // sourceAreaEspecialidade,
			// // clinica.getAreasEspecialidade());
			// EditarClinicaMB editarClinicaMB = (EditarClinicaMB)
			// getBean(EditarClinicaMB.NOME_MANAGER_BEAN);
			// editarClinicaMB.setClinica(novaClinica);
			// retorno = EditarClinicaMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que salva uma clínica
	 * 
	 * @return
	 */
	public String salvar() {
		String retorno = null;
		try {

			// ManterClinicaControle controle =
			// ManterClinicaControle.getInstance();
			// Usuario usuarioLogado = obterUsuarioLogado();
			// controle.salvar(clinica, usuarioLogado);
			// ListarClinicaMB listarClinicaMB = (ListarClinicaMB)
			// getBean(ListarClinicaMB.NOME_MANAGER_BEAN);
			// List<Clinica> lista = controle.obterTodos();
			// listarClinicaMB.setLista(lista);
			// retorno = ListarClinicaMB.CAMINHO_TELA;
			info("Clinica salva com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela a edição de uma clinica
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = EditarClinicaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
