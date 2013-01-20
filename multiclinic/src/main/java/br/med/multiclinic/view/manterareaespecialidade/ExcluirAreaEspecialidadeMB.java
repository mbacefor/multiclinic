/**
 * 
 */
package br.med.multiclinic.view.manterareaespecialidade;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.med.multiclinic.domain.AreaEspecialidade;
import br.med.multiclinic.util.FacesBean;

/**
 * Manager Bean que representa a tela de exclusão
 * 
 * @author fa7bd
 * 
 */

@ManagedBean(name = "excluirAreaEspecialidadeMB")
@SessionScoped
public class ExcluirAreaEspecialidadeMB extends FacesBean {
	public static final String NOME_MANAGER_BEAN = "excluirAreaEspecialidadeMB";
	public static final String CAMINHO_TELA = "/pages/manterareaespecialidade/excluirAreaEspecialidade.xhtml";

	private AreaEspecialidade areaEspecialidade = new AreaEspecialidade();

	public AreaEspecialidade getAreaEspecialidade() {
		return areaEspecialidade;
	}

	public void setAreaEspecialidade(AreaEspecialidade areaEspecialidade) {
		this.areaEspecialidade = areaEspecialidade;
	}

	public String excluir() {
		String retorno = null;

		try {
//			ManterAreaEspecialidadeControle.getInstance().excluir(areaEspecialidade);
//			ListarAreaEspecialidadeMB listarAreaEspecialidadeMB = (ListarAreaEspecialidadeMB) getBean(ListarAreaEspecialidadeMB.NOME_MANAGER_BEAN);
//			List<AreaEspecialidade> lista = ManterAreaEspecialidadeControle.getInstance()
//					.obterTodos();
//			listarAreaEspecialidadeMB.setLista(lista);
//			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
//			info("Exclusão realizada com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public String desistirExcluir() {
		String retorno = null;
		try {
			retorno = ListarAreaEspecialidadeMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

}
