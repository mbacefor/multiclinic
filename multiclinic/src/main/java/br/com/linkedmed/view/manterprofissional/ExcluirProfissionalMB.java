package br.com.linkedmed.view.manterprofissional;

import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import br.com.linkedmed.business.ManterProfissionalBC;
import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.domain.Profissional;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@javax.enterprise.context.SessionScoped
public class ExcluirProfissionalMB extends FacesBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "excluirProfissionalMB";
	public static final String CAMINHO_TELA = "/pages/manterprofissional/excluirProfissional.xhtml";

	private Profissional pessoa = new Profissional();

	private DualListModel<AreaEspecialidade> areasEspecilidades;

	@Inject
	private ManterProfissionalBC manterProfissionalBC;

	public void popularDualListModel(List<AreaEspecialidade> source,
			List<AreaEspecialidade> target) {
		source.removeAll(target);
		setAreasEspecilidades(new DualListModel<AreaEspecialidade>(source,
				target));
	}

	@Transactional
	public String excluir() {
		String retorno = null;

		try {
			manterProfissionalBC.excluir(pessoa);
			ListarProfissionalMB listarProfissionalMB = (ListarProfissionalMB) getBean(ListarProfissionalMB.NOME_MANAGER_BEAN);
			List<Profissional> lista = manterProfissionalBC.obterTodos();
			listarProfissionalMB.setLista(lista);
			retorno = ListarProfissionalMB.CAMINHO_TELA;
			info("Profissional excluído.");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String sairSemSalvar() {
		String retorno = null;
		try {
			retorno = ListarProfissionalMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;

	}

	public DualListModel<AreaEspecialidade> getAreasEspecilidades() {
		return areasEspecilidades;
	}

	public void setAreasEspecilidades(
			DualListModel<AreaEspecialidade> areasEspecilidades) {
		this.areasEspecilidades = areasEspecilidades;
	}

	public Profissional getPessoa() {
		return pessoa;
	}

	public void setPessoa(Profissional pessoa) {
		this.pessoa = pessoa;
	}

}
