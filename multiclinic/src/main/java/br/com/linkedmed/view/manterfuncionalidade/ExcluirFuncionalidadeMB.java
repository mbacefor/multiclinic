package br.com.linkedmed.view.manterfuncionalidade;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.com.linkedmed.business.ManterFuncionalidadeBC;
import br.com.linkedmed.domain.Funcionalidade;
import br.com.linkedmed.util.FacesBean;

@ViewController
@javax.enterprise.context.SessionScoped
@RequiredRole("ManterFuncionalidade")
public class ExcluirFuncionalidadeMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "excluirFuncionalidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterfuncionalidade/excluirFuncionalidade.xhtml";

	private Funcionalidade funcionalidade;
	@Inject
	ListarFuncionalidadeMB listarFuncionalidadeMB;
	@Inject
	private ManterFuncionalidadeBC manterFuncionalidadeBC;

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public String excluir() {
		String retorno = null;
		try {
			manterFuncionalidadeBC.excluir(funcionalidade);
			List<Funcionalidade> lista = manterFuncionalidadeBC.obterTodos();
			listarFuncionalidadeMB.setLista(lista);
			retorno = ListarFuncionalidadeMB.CAMINHO_TELA;
			info("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String desistirExcluir() {
		String retorno = null;
		try {
			retorno = ListarFuncionalidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
