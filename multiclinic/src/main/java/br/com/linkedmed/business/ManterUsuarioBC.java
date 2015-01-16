/**
 * 
 */
package br.com.linkedmed.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.persistence.UsuarioDAO;

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