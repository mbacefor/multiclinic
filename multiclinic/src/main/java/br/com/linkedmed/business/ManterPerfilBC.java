/**
 * 
 */
package br.com.linkedmed.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.com.linkedmed.domain.Perfil;
import br.com.linkedmed.persistence.PerfilDAO;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class ManterPerfilBC extends
		GenericoBC<Perfil, Long, PerfilDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}