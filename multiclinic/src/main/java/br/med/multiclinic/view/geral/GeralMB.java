/**
 * 
 */
package br.med.multiclinic.view.geral;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.med.multiclinic.business.ManterFuncionalidadeBC;
import br.med.multiclinic.business.ManterPerfilBC;
import br.med.multiclinic.business.ManterUsuarioBC;
import br.med.multiclinic.domain.Funcionalidade;
import br.med.multiclinic.domain.Perfil;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.seguranca.Credenciais;

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
	private Credenciais credenciais;

	@Inject
	private ManterUsuarioBC manterUsuarioBC;

	@Inject
	private ManterFuncionalidadeBC funcionalidadeBC;

	@Inject
	private ManterPerfilBC manterPerfilBC;

	/**
	 * 
	 */
	@Startup
	@Transactional
	public void cargaInicial() {
		try {

			if (funcionalidadeBC.findAll().isEmpty()) {
				Funcionalidade funcionalidade = new Funcionalidade();
				funcionalidade.setNome("ManterFuncionalidade");
				funcionalidade.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade, null);

				Funcionalidade funcionalidade2 = new Funcionalidade();
				funcionalidade2.setNome("ManterPerfil");
				funcionalidade2.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade2, null);

				Funcionalidade funcionalidade3 = new Funcionalidade();
				funcionalidade3.setNome("ManterUsuario");
				funcionalidade3.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade3, null);

				Funcionalidade funcionalidade4 = new Funcionalidade();
				funcionalidade4.setNome("ManterAreaEspecialidade");
				funcionalidade4.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade4, null);

				if (manterPerfilBC.findAll().isEmpty()) {
					Perfil perfil = new Perfil();
					perfil.setNome("Administrador");
					perfil.setAtivo(true);
					List<Funcionalidade> listaFuncionalidades = new ArrayList<Funcionalidade>();
					listaFuncionalidades.add(funcionalidade);
					listaFuncionalidades.add(funcionalidade2);
					listaFuncionalidades.add(funcionalidade3);
					listaFuncionalidades.add(funcionalidade4);
					
					perfil.setFuncionalidades(listaFuncionalidades);
					manterPerfilBC.salvar(perfil, null);

					if (manterUsuarioBC.findAll().isEmpty()) {
						Usuario usuario = new Usuario();
						usuario.setEmail("root@netclinicas.com");
						usuario.setSenha("12345678");
						usuario.setAtivo(true);
						usuario.setDataCadastro(new Date());
						usuario.setDescricao("");
						usuario.setUsuarioCriador(null);
						usuario.setPerfil(perfil);
						manterUsuarioBC.insert(usuario);
						manterPerfilBC.salvar(perfil, usuario);
			
					}
					

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Number getTamanho(Number numero) {
		return numero;
	}

	public Usuario getUsuarioLogado() {
		return credenciais.getUsuarioLogado();
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
