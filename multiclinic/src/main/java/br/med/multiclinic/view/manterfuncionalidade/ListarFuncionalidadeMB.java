package br.med.multiclinic.view.manterfuncionalidade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.med.multiclinic.business.ManterFuncionalidadeBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.util.FacesBean;

@ViewController
@ManagedBean(name = "listarFuncionalidadeMB")
@javax.enterprise.context.SessionScoped
public class ListarFuncionalidadeMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "listarFuncionalidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterfuncionalidade/listarFuncionalidade.xhtml";

	private List<Funcionalidade> lista = new ArrayList<Funcionalidade>();
	@Inject
	private ManterFuncionalidadeBC manterFuncionalidadeBC;

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
			EditarFuncionalidadeMB editarFuncionalidade = (EditarFuncionalidadeMB) getBean(EditarFuncionalidadeMB.NOME_MANAGER_BEAN);
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
			ExcluirFuncionalidadeMB excluirFuncionalidade = (ExcluirFuncionalidadeMB) getBean(ExcluirFuncionalidadeMB.NOME_MANAGER_BEAN);
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
