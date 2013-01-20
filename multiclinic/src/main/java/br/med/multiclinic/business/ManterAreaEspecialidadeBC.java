/**
 * 
 */
package br.med.multiclinic.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.persistence.AreaEspecialidadeDAO;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class ManterAreaEspecialidadeBC extends
		GenericoBC<AreaEspecialidade, Long, AreaEspecialidadeDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}