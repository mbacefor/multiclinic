package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.template.EntidadeGeralTemplate;

@PersistenceController
public class GenericoDAO extends JPACrud<EntidadeGeralTemplate, Long> {

	private static final long serialVersionUID = 1L;

}