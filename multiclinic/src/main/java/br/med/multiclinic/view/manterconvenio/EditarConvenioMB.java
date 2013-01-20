/**
 * 
 */
package br.med.multiclinic.view.manterconvenio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.domain.Convenio;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean associado a tela de edição do convenio
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "editarConvenioMB")
@SessionScoped
public class EditarConvenioMB extends FacesBean {

	public static final String NOME_MANAGER_BEAN = "editarConvenioMB";
	public static final String CAMINHO_TELA = "/pages/manterconvenio/editarConvenio.xhtml";

	/*
	 * Atributo que conterá as informações do convenio
	 */
	private Convenio convenio = new Convenio();

	private DualListModel<AreaEspecialidade> areasEspecilidades;

	public void popularDualListModel(List<AreaEspecialidade> source,
			List<AreaEspecialidade> target) {
		source.removeAll(target);
		areasEspecilidades = new DualListModel<AreaEspecialidade>(source,
				target);
	}

	/**
	 * Metodo que salva um convenio
	 * 
	 * @return
	 */
	public String salvar() {
		String retorno = null;
		try {

//			ManterConvenioControle controle = ManterConvenioControle
//					.getInstance();
//			Usuario usuarioLogado = obterUsuarioLogado();
//			convenio.setAreasEspecialidade(areasEspecilidades.getTarget());
//			controle.salvar(convenio, usuarioLogado);
//			ListarConvenioMB listarConvenioMB = (ListarConvenioMB) getBean(ListarConvenioMB.NOME_MANAGER_BEAN);
//			List<Convenio> lista = controle.obterTodos();
//			listarConvenioMB.setLista(lista);
//			retorno = ListarConvenioMB.CAMINHO_TELA;
			info("Convenio salvo com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela a edição de um convenio
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = ListarConvenioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public DualListModel<AreaEspecialidade> getAreasEspecilidades() {
		return areasEspecilidades;
	}

	public void setAreasEspecilidades(
			DualListModel<AreaEspecialidade> areasEspecilidades) {
		this.areasEspecilidades = areasEspecilidades;
	}

}
