/**
 * 
 */
package br.med.multiclinic.view.manterclinica;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.Clinica;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean associado a tela de edição das clínicas
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "listarClinicaMB")
@SessionScoped
public class ListarClinicaMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "listarClinicaMB";
	public static final String CAMINHO_TELA = "/pages/manterclinica/listarClinica.xhtml";
	/**
	 * Representa a lista de clínicas
	 */
	private List<Clinica> lista = new ArrayList<Clinica>();

	private Clinica entidadeCorrente = null; 
	
	public List<Clinica> getLista() {
		return lista;
	}

	public void setLista(List<Clinica> lista) {
		this.lista = lista;
	}

	/**
	 * Metodo que inicia a nova clínica
	 * 
	 * @return
	 */
	public String prepararListar() {
		String retorno = null;
		try {
			retorno = CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
	
	public String prepararEditar(){
		String retorno = null;
		try {
			
			EditarClinicaMB editarClinicaMB = (EditarClinicaMB) getBean(EditarClinicaMB.NOME_MANAGER_BEAN);
			editarClinicaMB.setClinica(entidadeCorrente);		
			retorno = EditarClinicaMB.CAMINHO_TELA;		
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
	
	public String prepararExcluir(){
		String retorno = null;
		try {
			
			ExcluirClinicaMB excluirClinicaMB = (ExcluirClinicaMB) getBean(ExcluirClinicaMB.NOME_MANAGER_BEAN);
			excluirClinicaMB.setClinica(entidadeCorrente);
			warn("Desear realmente excluir a Clínica?");
			retorno = ExcluirClinicaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Clinica getEntidadeCorrente() {
		return entidadeCorrente;
	}


	public void setEntidadeCorrente(Clinica entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

}
