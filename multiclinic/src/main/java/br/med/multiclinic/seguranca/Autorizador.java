package br.med.multiclinic.seguranca;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Usuario;

@Default
public class Autorizador implements Authorizer {

	private static final long serialVersionUID = 1L;

	@Inject
	private SecurityContext context;

	@Inject
	private Credenciais credenciais;

	@Override
	public boolean hasRole(String role) {
		String usr = context.getUser().getId();
		boolean authorized = false;

		Usuario usuarioLogado = credenciais.getUsuarioLogado();

		if (usuarioLogado != null && usuarioLogado.getPerfil() != null) {
			List<Funcionalidade> lista = usuarioLogado.getPerfil()
					.getFuncionalidades();

			for (Funcionalidade funcionalidade : lista) {
				if (funcionalidade.getNome().equals(role)
						&& funcionalidade.getAtivo()) {
					authorized = true;
					return authorized;
				}
			}
		}

		if (usr.equals("admin")) {
			authorized = true;
		}

		return authorized;
	}

	@Override
	public boolean hasPermission(String arg0, String arg1) {
		String usr = context.getUser().getId();
		boolean authorized = false;

		if (usr.equals("zyc") && arg0.equals("hello") && arg1.equals("say")) {
			authorized = true;
		} else if (context.hasRole("administrators")) {
			authorized = true;
		}

		return authorized;

	}
}
