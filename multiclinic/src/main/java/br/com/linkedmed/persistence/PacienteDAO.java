package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Paciente;

@PersistenceController
public class PacienteDAO extends JPACrud<Paciente, Long> {

	private static final long serialVersionUID = 1L;

}