package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Sala;

@PersistenceController
public class SalaDAO extends JPACrud<Sala, Long> {

	private static final long serialVersionUID = 1L;

}