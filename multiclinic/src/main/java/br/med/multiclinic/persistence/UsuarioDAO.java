package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;

}