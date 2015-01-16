package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.AreaEspecialidade;

@PersistenceController
public class AreaEspecialidadeDAO extends JPACrud<AreaEspecialidade, Long> {

	private static final long serialVersionUID = 1L;

}