package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.Convenio;

@PersistenceController
public class ConvenioDAO extends JPACrud<Convenio, Long> {

	private static final long serialVersionUID = 1L;

}