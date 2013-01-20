/**
 * 
 */
package br.med.multiclinic.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.med.multiclinic.domain.Perfil;
import br.med.multiclinic.persistence.PerfilDAO;

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