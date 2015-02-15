/**
 * 
 */
package br.com.linkedmed.view.geral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.com.linkedmed.business.ManterClinicaBC;
import br.com.linkedmed.domain.Clinica;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;

@ViewController
@javax.enterprise.context.SessionScoped
public class IndexClinicasMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "indexClinicasMB";
	public static final String CAMINHO_TELA = "/pages/geral/indexClinicas.xhtml";

	private Clinica clinicaAtual;

	@Inject
	private ManterClinicaBC manterClinicaBC;

	private List<SelectItem> listaClinicasSelectItem;

	public List<SelectItem> getListaClinicasSelectItem() {
		atualizaListagem();
		return listaClinicasSelectItem;
	}

	public void setListaClinicasSelectItem(
			List<SelectItem> listaClinicasSelectItem) {
		this.listaClinicasSelectItem = listaClinicasSelectItem;
	}

	/**
	 * 
	 */
	public void atualizaListagem() {
		try {

			List<Clinica> listaClinicas = manterClinicaBC.obterTodos();
			listaClinicasSelectItem = new ArrayList<SelectItem>();
			for (Iterator<Clinica> iterator = listaClinicas.iterator(); iterator
					.hasNext();) {
				Clinica clinica = iterator.next();
				listaClinicasSelectItem.add(new SelectItem(clinica, clinica
						.getNome()));

			}

		} catch (Exception e) {
			error(e.getMessage());
		}
	}

	public Clinica getClinicaAtual() {
		return clinicaAtual;
	}

	public void setClinicaAtual(Clinica clinicaAtual) {
		this.clinicaAtual = clinicaAtual;
	}

}
