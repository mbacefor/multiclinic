/**
 * 
 */
package br.com.linkedmed.view.geral;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.linkedmed.util.FacesBean;

@ManagedBean(name = "indexUsuarioMB")
@SessionScoped
public class IndexUsuarioMB extends FacesBean {

	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "indexUsuarioMB";
	public static final String CAMINHO_TELA = "/pages/geral/indexUsuario.xhtml";

	/**
	 * 
	 */
	public IndexUsuarioMB() {
		// TODO Auto-generated constructor stub
	}

	

		
}
