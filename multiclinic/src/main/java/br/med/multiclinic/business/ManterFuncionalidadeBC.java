/**
 * 
 */
package br.med.multiclinic.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.persistence.FuncionalidadeDAO;

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