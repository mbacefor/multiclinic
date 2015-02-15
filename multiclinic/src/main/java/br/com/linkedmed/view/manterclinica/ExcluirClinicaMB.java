/**
 * 
 */
package br.com.linkedmed.view.manterclinica;

import java.util.List;

import javax.inject.Inject;

import br.com.linkedmed.business.ManterClinicaBC;
import br.com.linkedmed.domain.Clinica;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

/**
 * Manager Bean que representa a tela de exclusão
 * 
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
public class ExcluirClinicaMB extends FacesBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "excluirClinicaMB";
	public static final String CAMINHO_TELA = "/pages/manterclinica/excluirClinica.xhtml";

	private Clinica clinica = new Clinica();

	@Inject
	private ManterClinicaBC manterClinicaBC;

	@Transactional
	public String excluir() {
		String retorno = null;

		try {
			manterClinicaBC.excluir(clinica);
			ListarClinicaMB listarClinicaMB = (ListarClinicaMB) getBean(ListarClinicaMB.NOME_MANAGER_BEAN);
			List<Clinica> lista = manterClinicaBC.obterTodos();
			listarClinicaMB.setLista(lista);
			retorno = ListarClinicaMB.CAMINHO_TELA;
			info("Clinica excluída.");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String sairSemExcluir() {
		String retorno = null;
		try {
			retorno = ListarClinicaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

}
