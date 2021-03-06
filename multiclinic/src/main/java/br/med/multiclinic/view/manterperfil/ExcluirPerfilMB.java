package br.med.multiclinic.view.manterperfil;

import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.med.multiclinic.business.ManterPerfilBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Perfil;
import br.med.multiclinic.util.FacesBean;

@ViewController
@javax.enterprise.context.SessionScoped
@RequiredRole("ManterPerfil")
public class ExcluirPerfilMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "excluirPerfilMB";
	public static final String CAMINHO_TELA = "/pages/manterperfil/excluirPerfil.xhtml";

	private Perfil perfil = new Perfil();

	private DualListModel<Funcionalidade> funcionalidades;

	@Inject
	private ManterPerfilBC manterPerfilBC;

	@Transactional
	public String excluir() {
		String retorno = null;

		try {
			manterPerfilBC.excluir(perfil);
			ListarPerfilMB listarPerfilMB = (ListarPerfilMB) getBean(ListarPerfilMB.NOME_MANAGER_BEAN);
			List<Perfil> lista = manterPerfilBC.obterTodos();
			listarPerfilMB.setLista(lista);
			retorno = ListarPerfilMB.CAMINHO_TELA;
			info("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			error(e.getMessage());
		}
		return retorno;
	}

	public String sairSemExcluir() {
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