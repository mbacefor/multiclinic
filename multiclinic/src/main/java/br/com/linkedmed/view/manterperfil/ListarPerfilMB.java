package br.com.linkedmed.view.manterperfil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.com.linkedmed.business.ManterFuncionalidadeBC;
import br.com.linkedmed.business.ManterPerfilBC;
import br.com.linkedmed.domain.Funcionalidade;
import br.com.linkedmed.domain.Perfil;
import br.com.linkedmed.util.FacesBean;

@ViewController
@javax.enterprise.context.SessionScoped
@RequiredRole("ManterPerfil")
public class ListarPerfilMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "listarPerfilMB";
	public static final String CAMINHO_TELA = "/pages/manterperfil/listarPerfil.xhtml";

	private List<Perfil> lista = new ArrayList<Perfil>();
	private Perfil entidadeCorrente = null;
	@Inject
	private ManterPerfilBC manterPerfilBC;
	@Inject
	private ManterFuncionalidadeBC funcionalidadeBC;

	public ListarPerfilMB() {
		super();
	}

	public String prepararListar() {
		String retorno = null;

		try {
			setLista(manterPerfilBC.obterTodos());
			retorno = ListarPerfilMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	public String prepararEditar() {

		String retorno = null;

		try {
			EditarPerfilMB editarPerfilMB = (EditarPerfilMB) getBean(EditarPerfilMB.NOME_MANAGER_BEAN);
			editarPerfilMB.setPerfil(entidadeCorrente);

			List<Funcionalidade> sourceFuncionalidades = funcionalidadeBC
					.obterTodos();

			sourceFuncionalidades.removeAll(entidadeCorrente
					.getFuncionalidades());

			DualListModel<Funcionalidade> funcionalidades = new DualListModel<Funcionalidade>(
					sourceFuncionalidades,
					entidadeCorrente.getFuncionalidades());
			editarPerfilMB.setFuncionalidades(funcionalidades);

			retorno = EditarPerfilMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	public String prepararExcluir() {
		String retorno = null;
		try {
			ExcluirPerfilMB excluirPerfilMB = (ExcluirPerfilMB) getBean(ExcluirPerfilMB.NOME_MANAGER_BEAN);
			excluirPerfilMB.setPerfil(entidadeCorrente);
			List<Funcionalidade> sourceFuncionalidades = funcionalidadeBC
					.obterTodos();

			sourceFuncionalidades.removeAll(entidadeCorrente
					.getFuncionalidades());

			DualListModel<Funcionalidade> funcionalidades = new DualListModel<Funcionalidade>(
					sourceFuncionalidades,
					entidadeCorrente.getFuncionalidades());
			excluirPerfilMB.setFuncionalidades(funcionalidades);

			warn("Deseja realmente excluir o registro?");
			retorno = ExcluirPerfilMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public List<SelectItem> getOpcoesSituacao() {
		return Arrays.asList(new SelectItem("", "Todos"), new SelectItem(
				"true", "Ativo"), new SelectItem("false", "Inativo"));
	}

	public List<Perfil> getLista() {
		return lista;
	}

	public void setLista(List<Perfil> lista) {
		this.lista = lista;
	}

	public Perfil getEntidadeCorrente() {
		return entidadeCorrente;
	}

	public void setEntidadeCorrente(Perfil entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}
}