/**
 * 
 */
package br.com.linkedmed.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.persistence.AreaEspecialidadeDAO;

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