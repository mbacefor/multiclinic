package br.com.linkedmed.persistence;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	private static final String queryEmail = "from Usuario where email=?";

	public List<Usuario> findByeMail(String email) {

		return getEntityManager().createQuery(queryEmail, Usuario.class)
				.setParameter(1, email).getResultList();

		// return createQuery(queryEmail).setParameter(0,
		// email).getResultList();

	}

}