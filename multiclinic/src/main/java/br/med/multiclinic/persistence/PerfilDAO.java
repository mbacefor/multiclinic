package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.Perfil;

@PersistenceController
public class PerfilDAO extends JPACrud<Perfil, Long> {

	private static final long serialVersionUID = 1L;

}