package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.Profissional;

@PersistenceController
public class ProfissionalDAO extends JPACrud<Profissional, Long> {

	private static final long serialVersionUID = 1L;

}