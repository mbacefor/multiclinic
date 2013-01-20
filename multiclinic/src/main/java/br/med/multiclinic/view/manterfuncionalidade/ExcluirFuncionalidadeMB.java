package br.med.multiclinic.view.manterfuncionalidade;

import java.util.List;

import javax.faces.bean.SessionScoped;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterFuncionalidadeBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.util.FacesBean;

@ViewController
@SessionScoped
public class ExcluirFuncionalidadeMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "excluirFuncionalidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterfuncionalidade/excluirFuncionalidade.xhtml";

	private Funcionalidade funcionalidade;

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
			ListarFuncionalidadeMB listarFuncionalidadeMB = (ListarFuncionalidadeMB) getBean(ListarFuncionalidadeMB.NOME_MANAGER_BEAN);
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
