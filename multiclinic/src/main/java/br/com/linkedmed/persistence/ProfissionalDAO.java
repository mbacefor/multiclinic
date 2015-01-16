package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Profissional;

@PersistenceController
public class ProfissionalDAO extends JPACrud<Profissional, Long> {

	private static final long serialVersionUID = 1L;

}