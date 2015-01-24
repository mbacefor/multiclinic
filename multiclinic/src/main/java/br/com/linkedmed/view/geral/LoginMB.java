/**
 * 
 */
package br.com.linkedmed.view.geral;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.com.linkedmed.seguranca.Autenticador;
import br.com.linkedmed.seguranca.Autorizador;
import br.com.linkedmed.seguranca.Credenciais;
import br.com.linkedmed.util.FacesBean;

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

	private Boolean exibirTelaLogin = false;

	@Inject
	private Credenciais credentials;

	@Inject
	private Autenticador autenticador;

	@Inject
	private Autorizador autorizador;

	public String prepararLogin() {
		exibirTelaLogin = true;
		return null;
	}

	public String logar() {

		try {

			credentials.clear();
			credentials.setUsername(login);
			credentials.setPassword(senha);
			autenticador.authenticate();

		} catch (Exception e) {
			e.printStackTrace();
			error(e.getMessage());

		}
		exibirTelaLogin = false;
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

	public Boolean getExibirTelaLogin() {
		return this.exibirTelaLogin;
	}

	public void setExibirTelaLogin(Boolean exibirTelaLogin) {
		this.exibirTelaLogin = exibirTelaLogin;
	}

	public String logout() {
		String returno = null;
		try {
			credentials.clear();

		} catch (Exception e) {
			e.printStackTrace();
			error(e.getMessage());
		}
		return returno;
	}

	public Boolean validaAcesso(String role) {
		try {
			if (autorizador != null)
				return autorizador.hasRole(role);
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
