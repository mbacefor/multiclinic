/**
 * 
 */
package br.med.multiclinic.business;

import java.util.Date;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
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

	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			Usuario usuario = new Usuario();
			usuario.setEmail("root@netclinicas.com");
			usuario.setSenha("12345678");
			usuario.setAtivo(false);
			usuario.setDataCadastro(new Date());
			usuario.setDescricao("");
			usuario.setUsuarioCriador(null);
			insert(usuario);

			usuario = new Usuario();
			usuario.setEmail("ze@netclinicas.com");
			usuario.setSenha("12345678");
			usuario.setAtivo(true);
			usuario.setDataCadastro(new Date());
			usuario.setDescricao("");
			usuario.setUsuarioCriador(null);

			insert(usuario);

			usuario = new Usuario();
			usuario.setEmail("pedinho@netclinicas.com");
			usuario.setSenha("12345678");
			usuario.setAtivo(true);
			usuario.setDescricao("");
			usuario.setUsuarioCriador(null);

			insert(usuario);

		}
	}

}