/**
 * 
 */
package br.med.multiclinic.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.persistence.UsuarioDAO;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class ManterUsuarioBC extends GenericoBC<Usuario, Long, UsuarioDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	public List<Usuario> findByeMail(String email) {

		return usuarioDAO.findByeMail(email);

	}

}