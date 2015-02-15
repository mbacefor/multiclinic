package br.com.linkedmed.view.manterprofissional;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.linkedmed.business.ManterAreaEspecialidadeBC;
import br.com.linkedmed.business.ManterProfissionalBC;
import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.domain.Profissional;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;

@ViewController
@javax.enterprise.context.SessionScoped
public class ListarProfissionalMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "listarProfissionalMB";
	public static final String CAMINHO_TELA = "/pages/manterprofissional/listarProfissional.xhtml";

	private List<Profissional> lista = new ArrayList<Profissional>();

	@Inject
	private ManterProfissionalBC manterProfissionalBC;

	@Inject
	private ManterAreaEspecialidadeBC manterAreaEspecialidadeBC;

	public List<Profissional> getLista() {
		return lista;
	}

	public void setLista(List<Profissional> lista) {
		this.lista = lista;
	}

	private Profissional entidadeCorrente = null;

	public Profissional getEntidadeCorrente() {
		return entidadeCorrente;
	}

	public void setEntidadeCorrente(Profissional entidadeCorrente) {
		this.entidadeCorrente = entidadeCorrente;
	}

	/**
	 * Metodo associado ao caminho da tela do EDITAR MANTER PROFISSIONAL.
	 * 
	 * @return
	 */
	public String prepararListar() {
		String retorno = null;
		try {
			setLista(manterProfissionalBC.obterTodos());
			retorno = ListarProfissionalMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararEditar() {
		String retorno = null;
		try {
			List<AreaEspecialidade> sourceAreaEspecialidades = manterAreaEspecialidadeBC
					.obterTodos();

			EditarProfissionalMB editarProfissionalMB = (EditarProfissionalMB) getBean(EditarProfissionalMB.NOME_MANAGER_BEAN);
			editarProfissionalMB.setPessoa(entidadeCorrente);

			editarProfissionalMB.popularDualListModel(sourceAreaEspecialidades,
					entidadeCorrente.getAreasEspecialidade());

			retorno = EditarProfissionalMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararExcluir() {
		String retorno = null;
		try {
			List<AreaEspecialidade> sourceAreaEspecialidade = manterAreaEspecialidadeBC
					.obterTodos();

			ExcluirProfissionalMB excluirProfissionalMB = (ExcluirProfissionalMB) getBean(ExcluirProfissionalMB.NOME_MANAGER_BEAN);
			excluirProfissionalMB.setPessoa(entidadeCorrente);

			excluirProfissionalMB.popularDualListModel(sourceAreaEspecialidade,
					entidadeCorrente.getAreasEspecialidade());
			warn("Você deseja mesmo excluir esse registro? ");
			retorno = ExcluirProfissionalMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
