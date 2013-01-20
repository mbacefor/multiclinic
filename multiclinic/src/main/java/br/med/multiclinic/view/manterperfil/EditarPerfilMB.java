package br.med.multiclinic.view.manterperfil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterFuncionalidadeBC;
import br.med.multiclinic.business.ManterPerfilBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Perfil;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

@ViewController
@javax.enterprise.context.SessionScoped
public class EditarPerfilMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "editarPerfilMB";
	public static final String CAMINHO_TELA = "/pages/manterperfil/editarPerfil.xhtml";

	private Perfil perfil = new Perfil();

	private DualListModel<Funcionalidade> funcionalidades;

	@Inject
	private ManterPerfilBC manterPerfilBC;

	@Inject
	private ManterFuncionalidadeBC funcionalidadeBC;

	public String prepararNovo() {
		String retorno = null;
		try {
			perfil = new Perfil();
			perfil.setFuncionalidades(new ArrayList<Funcionalidade>());

			List<Funcionalidade> sourceFuncionalidades = funcionalidadeBC
					.obterTodos();
			funcionalidades = new DualListModel<Funcionalidade>(
					sourceFuncionalidades, perfil.getFuncionalidades());

			Perfil novoPerfil = new Perfil();
			EditarPerfilMB editarPerfilMB = (EditarPerfilMB) getBean(EditarPerfilMB.NOME_MANAGER_BEAN);
			editarPerfilMB.setPerfil(novoPerfil);

			retorno = EditarPerfilMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String salvar() {
		String retorno = null;
		try {

			Usuario usuarioLogado = obterUsuarioLogado();

			perfil.setFuncionalidades(funcionalidades.getTarget());

			manterPerfilBC.salvar(perfil, usuarioLogado);

			ListarPerfilMB listarPerfilMB = (ListarPerfilMB) getBean(ListarPerfilMB.NOME_MANAGER_BEAN);
			List<Perfil> lista = manterPerfilBC.obterTodos();
			listarPerfilMB.setLista(lista);

			retorno = ListarPerfilMB.CAMINHO_TELA;

			info("Perfil salvo com sucesso!");

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String sairSemSalvar() {
		String retorno = null;
		try {
			retorno = ListarPerfilMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public DualListModel<Funcionalidade> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(DualListModel<Funcionalidade> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
}