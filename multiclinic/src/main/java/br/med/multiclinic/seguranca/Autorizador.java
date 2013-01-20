package br.med.multiclinic.seguranca;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;

@Default
public class Autorizador implements Authorizer {

	private static final long serialVersionUID = 1L;

	@Inject
	private SecurityContext context;

	@Override
	public boolean hasRole(String role) {
		String usr = context.getUser().getId();
		boolean authorized = false;

		if (usr.equals("admin") && role.equals("administrators")) {
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
