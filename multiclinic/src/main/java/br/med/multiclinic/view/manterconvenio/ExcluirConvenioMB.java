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
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean que representa a tela de exclusão
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "excluirConvenioMB")
@SessionScoped
public class ExcluirConvenioMB extends FacesBean {
	public static final String NOME_MANAGER_BEAN = "excluirConvenioMB";
	public static final String CAMINHO_TELA = "/pages/manterconvenio/excluirConvenio.xhtml";

	private Convenio convenio = new Convenio();

	private DualListModel<AreaEspecialidade> areasEspecilidades;

	public void popularDualListModel(List<AreaEspecialidade> source,
			List<AreaEspecialidade> target) {
		source.removeAll(target);
		setAreasEspecilidades(new DualListModel<AreaEspecialidade>(source,
				target));
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public String excluir() {
		String retorno = null;

		try {
//			ManterConvenioControle.getInstance().excluir(convenio);
//			ListarConvenioMB listarConvenioMB = (ListarConvenioMB) getBean(ListarConvenioMB.NOME_MANAGER_BEAN);
//			List<Convenio> lista = ManterConvenioControle.getInstance()
//					.obterTodos();
//			listarConvenioMB.setLista(lista);
			retorno = ListarConvenioMB.CAMINHO_TELA;
			info("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String desistirExcluir() {
		String retorno = null;
		try {
			retorno = ListarConvenioMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public DualListModel<AreaEspecialidade> getAreasEspecilidades() {
		return areasEspecilidades;
	}

	public void setAreasEspecilidades(DualListModel<AreaEspecialidade> areasEspecilidades) {
		this.areasEspecilidades = areasEspecilidades;
	}

}
