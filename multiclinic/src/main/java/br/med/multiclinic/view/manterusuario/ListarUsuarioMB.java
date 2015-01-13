/**
 * 
 */
package br.med.multiclinic.view.manterusuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterPerfilBC;
import br.med.multiclinic.business.ManterUsuarioBC;
import br.med.multiclinic.domain.Perfil;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean associado a tela de edição do convenio
 * 
 * @author fa7bd
 * 
 */
@ViewController
@javax.enterprise.context.SessionScoped
public class ListarUsuarioMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "listarUsuarioMB";
	public static final String CAMINHO_TELA = "/pages/manterusuario/listarUsuario.xhtml";
	/**
	 * Representa a lista de convenios
	 */
	private List<Usuario> lista = new ArrayList<Usuario>();
	@Inject
	private ManterUsuarioBC manterUsuarioBC;
	@Inject
	private ManterPerfilBC manterPerfilBC;

	/*
	 * Atributo que representa o objeto que esta senod editado ou excluído
	 */
	private Usuario entidadeCorrente = null;

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	/**
	 * Metodo que inicia a listagem de convenio
	 * 
	 * @return
	 */
	@RequiredRole("ManterUsuario-listar")
	public String prepararListar() {
		String retorno = null;
		try {
			setLista(manterUsuarioBC.obterTodos());
			retorno = ListarUsuarioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que inicia a listagem de convenio
	 * 
	 * @return
	 */
	public String prepararEditar() {
		String retorno = null;
		try {

			List<Perfil> listaPerfil = manterPerfilBC.obterTodos();
			ArrayList<SelectItem> listaPerfis = new ArrayList<SelectItem>();
			for (Iterator<Perfil> iterator = listaPerfil.iterator(); iterator
					.hasNext();) {
				Perfil perfil = iterator.next();
				listaPerfis.add(new SelectItem(perfil, perfil.getNome()));
			}

			EditarUsuarioMB editarConvenioMB = (EditarUsuarioMB) getBean(EditarUsuarioMB.NOME_MANAGER_BEAN);
			editarConvenioMB.setUsuario(entidadeCorrente);
			editarConvenioMB.setListaPerfis(listaPerfis);
			retorno = EditarUsuarioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que inicia a listagem de convenio
	 * 
	 * @return
	 */
	@RequiredRole("ManterUsuario-listar")
	public String prepararExcluir() {
		String retorno = null;
		try {
			ExcluirUsuarioMB excluirUsuarioMB = (ExcluirUsuarioMB) getBean(ExcluirUsuarioMB.NOME_MANAGER_BEAN);
			excluirUsuarioMB.setUsuario(entidadeCorrente);
			warn("Deseja realmente excluir o registro?");
			retorno = ExcluirUsuarioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Usuario getEntidadeCorrente() {
		return entidadeCorrente;
	}

	public void setEntidadeCorrente(Usuario entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

}