package br.com.linkedmed.view.manterfuncionalidade;

import java.util.ArrayList;
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
/**
 * MB da listegm de funcionalidade
 * @author mbacefor
 *
 */
public class ListarFuncionalidadeMB extends FacesBean {


	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "listarFuncionalidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterfuncionalidade/listarFuncionalidade.xhtml";

	private List<Funcionalidade> lista = new ArrayList<Funcionalidade>();
	@Inject
	private ManterFuncionalidadeBC manterFuncionalidadeBC;
	@Inject
	private EditarFuncionalidadeMB editarFuncionalidade;
	@Inject
	private ExcluirFuncionalidadeMB excluirFuncionalidade;
	/**
	 * Representa a entidade selecionada
	 */
	private Funcionalidade entidadeCorrente = null;

	public List<Funcionalidade> getLista() {
		return lista;
	}

	public void setLista(List<Funcionalidade> lista) {
		this.lista = lista;
	}

	/**
	 * Metodo que inicia a listagem de funcionalidade
	 * 
	 * @return
	 */
	public String prepararListar() {
		String retorno = null;
		try {
			setLista(manterFuncionalidadeBC.obterTodos());
			retorno = ListarFuncionalidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararEditar() {
		String retorno = null;
		try {
			editarFuncionalidade.setFuncionalidade(entidadeCorrente);
			retorno = EditarFuncionalidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararExcluir() {
		String retorno = null;

		try {
			excluirFuncionalidade.setFuncionalidade(entidadeCorrente);
			warn("Deseja realmente excluir o registro?");
			retorno = ExcluirFuncionalidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}

		return retorno;
	}

	public Funcionalidade getEntidadeCorrente() {
		return entidadeCorrente;
	}

	public void setEntidadeCorrente(Funcionalidade entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}
}
