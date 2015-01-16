package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Perfil;

@PersistenceController
public class PerfilDAO extends JPACrud<Perfil, Long> {

	private static final long serialVersionUID = 1L;

}