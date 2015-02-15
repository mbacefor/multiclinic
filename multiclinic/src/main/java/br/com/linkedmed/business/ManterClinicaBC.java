/**
 * 
 */
package br.com.linkedmed.business;

import br.com.linkedmed.domain.Clinica;
import br.com.linkedmed.persistence.ClinicaDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class ManterClinicaBC extends GenericoBC<Clinica, Long, ClinicaDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}