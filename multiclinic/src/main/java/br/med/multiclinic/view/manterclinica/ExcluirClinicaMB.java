/**
 * 
 */
package br.med.multiclinic.view.manterclinica;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.med.multiclinic.domain.Clinica;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean que representa a tela de exclusão
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "excluirClinicaMB")
public class ExcluirClinicaMB extends FacesBean {
	public static final String NOME_MANAGER_BEAN = "excluirClinicaMB";
	public static final String CAMINHO_TELA = "pages/manterclinica/excluirClinica.xhtml";
	
	private Clinica clinica = new Clinica();
	
	public Clinica getClinica() {
		return clinica;
	}
	
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	
	public String excluir() {
		String retorno = null;
		
		try {
//			ManterClinicaControle.getInstance().excluir(clinica);
//			ListarClinicaMB listarClinicaMB = (ListarClinicaMB) getBean(ListarClinicaMB.NOME_MANAGER_BEAN);
//			List<Clinica> lista = ManterClinicaControle.getInstance().obterTodos();
//			listarClinicaMB.setLista(lista);
//			retorno = ListarClinicaMB.CAMINHO_TELA;
			info("Clinica excluída.");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
}
