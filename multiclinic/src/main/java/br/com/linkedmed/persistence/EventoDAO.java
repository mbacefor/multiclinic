package br.com.linkedmed.persistence;

import br.com.linkedmed.domain.Evento;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EventoDAO extends JPACrud<Evento, Long> {

	private static final long serialVersionUID = 1L;

}