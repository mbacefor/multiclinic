package br.med.multiclinic.view.manterusuario;

/**
 * 
 */


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean que representa a tela de exclusão
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "excluirUsuarioMB")
@SessionScoped
public class ExcluirUsuarioMB extends FacesBean {
	public static final String NOME_MANAGER_BEAN = "excluirUsuarioMB";
	public static final String CAMINHO_TELA = "/pages/manterusuario/ExcluirUsuario.xhtml";

	private Usuario Usuario = new Usuario();

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	public String excluir() {
		String retorno = null;

		try {
//			ManterUsuarioControle.getInstance().excluir(Usuario);
//			ListarUsuarioMB listarUsuarioMB = (ListarUsuarioMB) getBean(ListarUsuarioMB.NOME_MANAGER_BEAN);
//			List<Usuario> lista = ManterUsuarioControle.getInstance()
//					.obterTodos();
//			listarUsuarioMB.setLista(lista);
//			retorno = ListarUsuarioMB.CAMINHO_TELA;
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
