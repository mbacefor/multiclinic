/**
 * 
 */
package br.med.multiclinic.view.geral;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.med.multiclinic.domain.Clinica;
import br.med.multiclinic.util.FacesBean;

@ManagedBean(name = "indexClinicasMB")
@RequestScoped
public class IndexClinicasMB extends FacesBean {

	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "indexClinicasMB";
	public static final String CAMINHO_TELA = "/pages/geral/indexClinicas.xhtml";

	private Clinica clinicaAtual;

	private List<SelectItem> listaClinicasSelectItem;

	public List<SelectItem> getListaClinicasSelectItem() {
		return listaClinicasSelectItem;
	}

	public void setListaClinicasSelectItem(List<SelectItem> listaClinicasSelectItem) {
		this.listaClinicasSelectItem = listaClinicasSelectItem;
	}

	/**
	 * 
	 */
	public IndexClinicasMB() {
//		try {
//			ManterClinicaControle clinicaControle = new ManterClinicaControle();
//			List<Clinica> listaClinicas = clinicaControle.obterTodos();
//			listaClinicasSelectItem = new ArrayList<SelectItem>();
//			for (Iterator iterator = listaClinicas.iterator(); iterator
//					.hasNext();) {
//				Clinica clinica = (Clinica) iterator.next();
//				listaClinicasSelectItem.add(new SelectItem(clinica, clinica
//						.getNome()));
//
//			}
//
//		} catch (Exception e) {
//			error(e.getMessage());
//		}
	}

	public String iniciarManterUsuario() {
		String retorno = null;

		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

	public Clinica getClinicaAtual() {
		return clinicaAtual;
	}

	public void setClinicaAtual(Clinica clinicaAtual) {
		this.clinicaAtual = clinicaAtual;
	}

}
