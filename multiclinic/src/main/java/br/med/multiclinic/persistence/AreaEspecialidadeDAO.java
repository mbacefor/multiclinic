package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.AreaEspecialidade;

@PersistenceController
public class AreaEspecialidadeDAO extends JPACrud<AreaEspecialidade, Long> {

	private static final long serialVersionUID = 1L;

}