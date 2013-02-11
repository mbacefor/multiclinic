/**
 * 
 */
package br.med.multiclinic.view.geral;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.seguranca.Autenticador;
import br.med.multiclinic.seguranca.Credenciais;
import br.med.multiclinic.util.FacesBean;

@ViewController
@javax.enterprise.context.RequestScoped
public class LoginMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "loginMB";

	private String login;

	private String senha;

	@Inject
	private Credenciais credentials;

	@Inject
	private Autenticador autenticador;

	public String logar() {
		boolean autenticado = false;
		try {

			credentials.clear();
			credentials.setUsername(login);
			credentials.setPassword(senha);
			autenticado = autenticador.authenticate();

		} catch (Exception e) {
			e.printStackTrace();
			error(e.getMessage());

		}
		return null;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
