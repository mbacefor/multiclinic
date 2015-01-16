package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Clinica;

@PersistenceController
public class ClinicaDAO extends JPACrud<Clinica, Long> {

	private static final long serialVersionUID = 1L;

}