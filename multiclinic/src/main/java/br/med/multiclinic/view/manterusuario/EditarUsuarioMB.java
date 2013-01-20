/**
 * 
 */
package br.med.multiclinic.view.manterusuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterPerfilBC;
import br.med.multiclinic.business.ManterUsuarioBC;
import br.med.multiclinic.domain.Perfil;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean associado a tela de edição do usuario
 * 
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
public class EditarUsuarioMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "editarUsuarioMB";
	public static final String CAMINHO_TELA = "/pages/manterusuario/EditarUsuario.xhtml";

	/*
	 * Atributo que conterá as informações do usuario
	 */
	private Usuario usuario = new Usuario();

	private List<SelectItem> listaPerfis;
	@Inject
	private ManterUsuarioBC manterUsuarioBC;

	@Inject
	private ManterPerfilBC manterPerfilBC;

	/**
	 * Metodo que inicia o novo usuario
	 * 
	 * @return
	 */
	public String prepararNovo() {
		String retorno = null;
		try {

			List<Perfil> listaPerfil = manterPerfilBC.obterTodos();
			Usuario novoUsuario = new Usuario();
			EditarUsuarioMB editarUsuarioMB = (EditarUsuarioMB) getBean(EditarUsuarioMB.NOME_MANAGER_BEAN);
			listaPerfis = new ArrayList<SelectItem>();
			for (Iterator<Perfil> iterator = listaPerfil.iterator(); iterator
					.hasNext();) {
				Perfil perfil = iterator.next();
				listaPerfis.add(new SelectItem(perfil, perfil.getNome()));
			}
			editarUsuarioMB.setUsuario(novoUsuario);
			retorno = EditarUsuarioMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que salva um usuario
	 * 
	 * @return
	 */
	public String salvar() {
		String retorno = null;
		try {

			Usuario usuarioLogado = obterUsuarioLogado();
			manterUsuarioBC.salvar(usuario, usuarioLogado);
			ListarUsuarioMB listarUsuarioMB = (ListarUsuarioMB) getBean(ListarUsuarioMB.NOME_MANAGER_BEAN);
			List<Usuario> lista = manterUsuarioBC.obterTodos();
			listarUsuarioMB.setLista(lista);
			retorno = ListarUsuarioMB.CAMINHO_TELA;
			info("usuario salvo com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela a edição de um usuario
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = ListarUsuarioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<SelectItem> getListaPerfis() {
		return listaPerfis;
	}

	public void setListaPerfis(List<SelectItem> listaPerfis) {
		this.listaPerfis = listaPerfis;
	}
}