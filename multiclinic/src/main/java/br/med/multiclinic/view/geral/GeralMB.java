/**
 * 
 */
package br.med.multiclinic.view.geral;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.med.multiclinic.business.ManterUsuarioBC;
import br.med.multiclinic.domain.Usuario;

@ViewController
@javax.enterprise.context.SessionScoped
public class GeralMB extends AbstractPageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos da classe
	 */

	public static final String NOME_MANAGER_BEAN = "geralMB";

	private Usuario usuarioLogado = null;

	@Inject
	private ManterUsuarioBC manterUsuarioBC;

	/**
	 * 
	 */
	@Startup
	public void cargaInicial() {
		try {

			usuarioLogado = null;
			usuarioLogado = manterUsuarioBC.obterTodosAtivos(Usuario.class)
					.get(0);
			System.out.println(usuarioLogado);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Number getTamanho(Number numero) {
		return numero;
	}

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null)
			usuarioLogado = manterUsuarioBC.obterTodosAtivos(Usuario.class)
					.get(0);
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
