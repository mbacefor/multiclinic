package br.med.multiclinic.view.manterperfil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterFuncionalidadeBC;
import br.med.multiclinic.business.ManterPerfilBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Perfil;
import br.med.multiclinic.util.FacesBean;

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