package br.com.linkedmed.view.manterprofissional;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.domain.Profissional;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;

/**
 * MANAGER BEAN ASSOCIADO A TELA DE EDIÇÃO DO MANTER PROFISSIONAL.
 * 
 * @author samuelgl
 */

@ManagedBean(name = "editarProfissionalMB")
@SessionScoped
public class EditarProfissionalMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "editarProfissionalMB";
	public static final String CAMINHO_TELA = "/pages/manterprofissional/editarProfissional.xhtml";

	private DualListModel<AreaEspecialidade> areasEspecilidades;

	public void popularDualListModel(List<AreaEspecialidade> source,
			List<AreaEspecialidade> target) {
		source.removeAll(target);
		areasEspecilidades = new DualListModel<AreaEspecialidade>(source,
				target);
	}

	public DualListModel<AreaEspecialidade> getAreasEspecilidades() {
		return areasEspecilidades;
	}

	public void setAreasEspecilidades(
			DualListModel<AreaEspecialidade> areasEspecilidades) {
		this.areasEspecilidades = areasEspecilidades;
	}

	private Profissional profissional = new Profissional();

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	/**
	 * Metodo associado ao caminho da tela do EDITAR MANTER PROFISSIONAL.
	 * 
	 * @return
	 */
	public String prepararNovo() {
		String retorno = null;
		try {
//			Profissional novoProfissional = new Profissional();
//
//			List<AreaEspecialidade> sourceAreaEspecialidade = ManterAreaEspecialidadeControle
//					.getInstance().obterTodos();
//
//			profissional
//					.setAreasEspecialidade(new ArrayList<AreaEspecialidade>());
//
//			areasEspecilidades = new DualListModel<AreaEspecialidade>(
//					sourceAreaEspecialidade,
//					profissional.getAreasEspecialidade());
//			EditarProfissionalMB editarProfissionalMB = (EditarProfissionalMB) getBean(EditarProfissionalMB.NOME_MANAGER_BEAN);
//			editarProfissionalMB.setProfissional(novoProfissional);
			retorno = EditarProfissionalMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo para salvar o Profissional.
	 * 
	 * @return
	 */
	public String salvar() {
		String retorno = null;
		try {
//			ManterProfissionalControle manterProfissionalControle = ManterProfissionalControle
//					.getInstance();
//
//			Usuario usuarioLogado = obterUsuarioLogado();
//			profissional.setAreasEspecialidade(areasEspecilidades.getTarget());
//			manterProfissionalControle.salvar(profissional, usuarioLogado);
//
//			ListarProfissionalMB listarProfissionalMB = (ListarProfissionalMB) getBean(ListarProfissionalMB.NOME_MANAGER_BEAN);
//			List<Profissional> lista = manterProfissionalControle.obterTodos();
//
//			listarProfissionalMB.setLista(lista);
//			retorno = ListarProfissionalMB.CAMINHO_TELA;
//
//			info("Profissional cadastrado com sucesso! ");

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela o Profissional.
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = ListarProfissionalMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
}
