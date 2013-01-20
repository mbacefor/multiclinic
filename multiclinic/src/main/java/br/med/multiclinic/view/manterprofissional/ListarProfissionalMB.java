package br.med.multiclinic.view.manterprofissional;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.domain.Profissional;
import br.med.multiclinic.util.FacesBean;

/**
 * MANAGER BEAN ASSOCIADO A TELA DE EDIÇÃO DO MANTER PROFISSIONAL.
 * 
 * @author samuelgl
 */

@ManagedBean(name = "listarProfissionalMB")
@SessionScoped
public class ListarProfissionalMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "listarProfissionalMB";
	public static final String CAMINHO_TELA = "/pages/manterprofissional/listarProfissional.xhtml";

	private List<Profissional> lista = new ArrayList<Profissional>();

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
		//	setLista(ManterProfissionalControle.getInstance().obterTodos());
			retorno = ListarProfissionalMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararEditar() {
		String retorno = null;
		try {
//			List<AreaEspecialidade> sourceAreaEspecialidades = ManterAreaEspecialidadeControle
//					.getInstance().obterTodos();
//
//			EditarProfissionalMB editarProfissionalMB = (EditarProfissionalMB) getBean(EditarProfissionalMB.NOME_MANAGER_BEAN);
//			editarProfissionalMB.setProfissional(entidadeCorrente);
//
//			editarProfissionalMB.popularDualListModel(sourceAreaEspecialidades,
//					entidadeCorrente.getAreasEspecialidade());

			retorno = EditarProfissionalMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararExcluir() {
		String retorno = null;
		try {
//			List<AreaEspecialidade> sourceAreaEspecialidade = ManterAreaEspecialidadeControle.getInstance().obterTodos();
//
//			ExcluirProfissionalMB excluirProfissionalMB = (ExcluirProfissionalMB) getBean(ExcluirProfissionalMB.NOME_MANAGER_BEAN);
//			excluirProfissionalMB.setProfissional(entidadeCorrente);
//
//			excluirProfissionalMB.popularDualListModel(sourceAreaEspecialidade, entidadeCorrente.getAreasEspecialidade());
			warn("Você deseja mesmo excluir esse registro? ");
			retorno = ExcluirProfissionalMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String prepararNovo() {
		String retorno = null;
		try {
			Profissional novoProfissional = new Profissional();
			EditarProfissionalMB editarProfissionalMB = (EditarProfissionalMB) getBean(EditarProfissionalMB.NOME_MANAGER_BEAN);

			editarProfissionalMB.setProfissional(novoProfissional);

//			List<AreaEspecialidade> sourceAreaEspecialidade = ManterAreaEspecialidadeControle
//					.getInstance().obterTodos();
//			novoProfissional
//					.setAreasEspecialidade(new ArrayList<AreaEspecialidade>());
//
//			editarProfissionalMB.popularDualListModel(sourceAreaEspecialidade,
//					novoProfissional.getAreasEspecialidade());

			retorno = EditarProfissionalMB.CAMINHO_TELA;
			
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
