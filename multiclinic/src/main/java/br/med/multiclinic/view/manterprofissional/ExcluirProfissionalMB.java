
package br.med.multiclinic.view.manterprofissional;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;

import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.domain.Profissional;
import br.med.multiclinic.util.FacesBean;

/**
 * MANAGER BEAN ASSOCIADO A TELA DE EDIÇÃO DO MANTER PROFISSIONAL.
 * @author samuelgl
 */

@ManagedBean(name="excluirProfissionalMB")
@SessionScoped
public class ExcluirProfissionalMB extends FacesBean{
	public static final String  NOME_MANAGER_BEAN = "excluirProfissionalMB";
	public static final String CAMINHO_TELA = "/pages/manterprofissional/excluirProfissional.xhtml";
	
	private Profissional profissional = new Profissional();
	
	private DualListModel<AreaEspecialidade> areasEspecilidades;

	public void popularDualListModel(List<AreaEspecialidade> source,
			List<AreaEspecialidade> target) {
		source.removeAll(target);
		setAreasEspecilidades(new DualListModel<AreaEspecialidade>(source,
				target));
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	public String excluir() {
		String retorno = null;
		
		try {
//			ManterProfissionalControle.getInstance().excluir(profissional);
//			ListarProfissionalMB listarProfissionalMB = (ListarProfissionalMB) getBean(ListarProfissionalMB.NOME_MANAGER_BEAN);
//			List<Profissional> lista = ManterProfissionalControle.getInstance().obterTodos();
//			listarProfissionalMB.setLista(lista);
//			retorno = ListarProfissionalMB.CAMINHO_TELA;
			info("Profissional excluído.");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}
	
	public String sairSemSalvar(){
		String retorno = null;
		try{
			retorno = ListarProfissionalMB.CAMINHO_TELA;
			
		}catch(Exception e){
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

	
}
