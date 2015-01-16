package br.com.linkedmed.view.manterusuario;

/**
 * 
 */

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.com.linkedmed.business.ManterUsuarioBC;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;

/**
 * Manager Bean que representa a tela de exclusão
 * 
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
@RequiredRole("ManterUsuario-excluir")
public class ExcluirUsuarioMB extends FacesBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "excluirUsuarioMB";
	public static final String CAMINHO_TELA = "/pages/manterusuario/ExcluirUsuario.xhtml";

	private Usuario Usuario = new Usuario();

	@Inject
	ManterUsuarioBC manterUsuarioBC;
	@Inject
	ListarUsuarioMB listarUsuarioMB;

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	@Transactional
	public String excluir() {
		String retorno = null;

		try {
			manterUsuarioBC.excluir(Usuario);
			List<Usuario> lista = manterUsuarioBC.obterTodos();
			listarUsuarioMB.setLista(lista);
			retorno = ListarUsuarioMB.CAMINHO_TELA;
			info("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String desistirExcluir() {
		String retorno = null;
		try {
			retorno = ListarUsuarioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
