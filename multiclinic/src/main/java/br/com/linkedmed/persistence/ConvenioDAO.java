package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Convenio;

@PersistenceController
public class ConvenioDAO extends JPACrud<Convenio, Long> {

	private static final long serialVersionUID = 1L;

}