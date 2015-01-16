package br.com.linkedmed.seguranca;

import java.io.Serializable;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.com.linkedmed.domain.Usuario;

@ViewController
@javax.enterprise.context.SessionScoped
public class Credenciais implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username = "";

	private String password = "";

	private Usuario usuarioLogado = null;

	public void clear() {
		username = null;
		password = null;
		usuarioLogado = null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
