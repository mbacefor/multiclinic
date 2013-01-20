package br.med.multiclinic.view.manterfuncionalidade;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.med.multiclinic.business.ManterFuncionalidadeBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

@ViewController
@SessionScoped
public class EditarFuncionalidadeMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "editarFuncionalidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterfuncionalidade/editarFuncionalidade.xhtml";

	private Funcionalidade funcionalidade;
	@Inject
	private EditarFuncionalidadeMB editarFuncionalidadeMB;
	@Inject
	private ManterFuncionalidadeBC genericoBC;

	/**
	 * Metodo que inicia uma nova funcionalidade
	 * 
	 * @return
	 */
	public String prepararNovo() {
		String retorno = null;
		try {
			Funcionalidade novaFuncionalidade = new Funcionalidade();
			editarFuncionalidadeMB.setFuncionalidade(novaFuncionalidade);
			retorno = EditarFuncionalidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			// error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que salva uma nova funcionalidade
	 * 
	 * @return
	 */
	@Transactional
	public String salvar() {
		String retorno = null;
		try {

			Usuario usuarioLogado = obterUsuarioLogado();
			genericoBC.salvar(funcionalidade, usuarioLogado);
			ListarFuncionalidadeMB listarFuncionalidadeMB = (ListarFuncionalidadeMB) getBean(ListarFuncionalidadeMB.NOME_MANAGER_BEAN);
			List<Funcionalidade> lista = genericoBC.obterTodos();
			listarFuncionalidadeMB.setLista(lista);
			retorno = ListarFuncionalidadeMB.CAMINHO_TELA;
			info("Funcionalidade salva com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela a inclusão de uma nova funcionalidade
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = ListarFuncionalidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

}