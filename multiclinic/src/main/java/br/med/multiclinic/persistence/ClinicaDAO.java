package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.Clinica;

@PersistenceController
public class ClinicaDAO extends JPACrud<Clinica, Long> {

	private static final long serialVersionUID = 1L;

}