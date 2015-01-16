/**
 * 
 */
package br.com.linkedmed.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.com.linkedmed.domain.Funcionalidade;
import br.com.linkedmed.persistence.FuncionalidadeDAO;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class ManterFuncionalidadeBC extends
		GenericoBC<Funcionalidade, Long, FuncionalidadeDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}