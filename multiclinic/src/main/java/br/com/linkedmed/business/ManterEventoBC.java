/**
 * 
 */
package br.com.linkedmed.business;

import br.com.linkedmed.domain.Evento;
import br.com.linkedmed.persistence.EventoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class ManterEventoBC extends GenericoBC<Evento, Long, EventoDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}