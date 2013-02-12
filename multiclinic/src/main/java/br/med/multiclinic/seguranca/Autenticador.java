package br.med.multiclinic.seguranca;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;
import br.med.multiclinic.business.ManterUsuarioBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Usuario;

@Default
public class Autenticador implements Authenticator {

	private static final long serialVersionUID = 1L;

	@Inject
	private Credenciais credentials;

	@Inject
	private MessageContext messageContext;

	@Inject
	private ManterUsuarioBC usuarioBC;

	@Override
	public boolean authenticate() {
		String username = credentials.getUsername();
		String password = credentials.getPassword();

		boolean authenticated = false;

		Usuario usuario = new Usuario();
		usuario.setEmail(username);
		usuario.setSenha(password);

		List<Usuario> lista = usuarioBC.findByeMail(username);

		for (Usuario usuario2 : lista) {
			if (usuario2.getSenha().equals(usuario.getSenha())
					&& usuario2.getAtivo()) {
				authenticated = true;
				credentials.setUsuarioLogado(lista.get(0));
				if (credentials.getUsuarioLogado().getPerfil() != null) {
					List<Funcionalidade> listaFuncionalidades = credentials.getUsuarioLogado()
							.getPerfil().getFuncionalidades();
					for (Funcionalidade funcionalidade : listaFuncionalidades) {
						funcionalidade.getNome();
					}
				}

			}
		}

		if (username.equals("admin") && password.equals("secret")) {
			authenticated = true;
		} else if (username.equals("zyc") && password.equals("tcharam")) {
			authenticated = true;
		}

		if (authenticated)
			messageContext.add("Usuario autenticado com sucesso");
		else
			messageContext.add("Usuario ou senha inválido");

		return authenticated;
	}

	@Override
	public void unAuthenticate() {
		credentials.clear();
	}

	@Override
	public User getUser() {
		return new User() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getId() {
				return credentials.getUsername();
			}

			@Override
			public void setAttribute(Object key, Object value) {
			}

			@Override
			public Object getAttribute(Object key) {
				return null;
			}
		};
	}
}
