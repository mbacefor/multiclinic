/**
 * 
 */
package br.com.linkedmed.view.geral;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.com.linkedmed.business.ManterAreaEspecialidadeBC;
import br.com.linkedmed.business.ManterFuncionalidadeBC;
import br.com.linkedmed.business.ManterPerfilBC;
import br.com.linkedmed.business.ManterUsuarioBC;
import br.com.linkedmed.domain.AreaEspecialidade;
import br.com.linkedmed.domain.Funcionalidade;
import br.com.linkedmed.domain.Perfil;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.seguranca.Credenciais;

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

	@Inject
	private Credenciais credenciais;

	@Inject
	private ManterUsuarioBC manterUsuarioBC;

	@Inject
	private ManterFuncionalidadeBC funcionalidadeBC;

	@Inject
	private ManterPerfilBC manterPerfilBC;

	@Inject
	private ManterAreaEspecialidadeBC manterAreaEspecialidadeBC;

	private String ocultaTAGUsuarioLogado = "hidden";

	private String ocultaTAGUsuarioNaoLogado = "hidden";

	private String templateAtual = "/templates/templatePrincipal.xhtml";

	public String getTemplateAtual() {
		return templateAtual;
	}

	public void setTemplateAtual(String templateAtual) {
		this.templateAtual = templateAtual;
	}

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
				funcionalidade3.setNome("ManterAreaEspecialidade");
				funcionalidade3.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade3, null);

				Funcionalidade funcionalidade4 = new Funcionalidade();
				funcionalidade4.setNome("ManterUsuario-listar");
				funcionalidade4.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade4, null);

				Funcionalidade funcionalidade5 = new Funcionalidade();
				funcionalidade5.setNome("ManterUsuario-editar");
				funcionalidade5.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade5, null);

				Funcionalidade funcionalidade6 = new Funcionalidade();
				funcionalidade6.setNome("ManterUsuario-excluir");
				funcionalidade6.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade6, null);

				Funcionalidade funcionalidade7 = new Funcionalidade();
				funcionalidade7.setNome("Area-Administracao");
				funcionalidade7.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade7, null);

				Funcionalidade funcionalidade8 = new Funcionalidade();
				funcionalidade8.setNome("Area-Usuario");
				funcionalidade8.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade8, null);

				Funcionalidade funcionalidade9 = new Funcionalidade();
				funcionalidade9.setNome("Area-Clinicas");
				funcionalidade9.setAtivo(true);
				funcionalidadeBC.salvar(funcionalidade9, null);

				if (manterPerfilBC.findAll().isEmpty()) {
					Perfil perfil = new Perfil();
					perfil.setNome("Administrador");
					perfil.setAtivo(true);
					List<Funcionalidade> listaFuncionalidades = new ArrayList<Funcionalidade>();
					listaFuncionalidades.add(funcionalidade);
					listaFuncionalidades.add(funcionalidade2);
					listaFuncionalidades.add(funcionalidade3);
					listaFuncionalidades.add(funcionalidade4);
					listaFuncionalidades.add(funcionalidade5);
					listaFuncionalidades.add(funcionalidade6);
					listaFuncionalidades.add(funcionalidade7);
					listaFuncionalidades.add(funcionalidade8);
					listaFuncionalidades.add(funcionalidade9);

					perfil.setFuncionalidades(listaFuncionalidades);
					manterPerfilBC.salvar(perfil, null);

					Perfil perfil1 = new Perfil();
					perfil1.setNome("Usuario");
					perfil1.setAtivo(true);
					List<Funcionalidade> listaFuncionalidades1 = new ArrayList<Funcionalidade>();
					listaFuncionalidades1.add(funcionalidade5);
					listaFuncionalidades1.add(funcionalidade8);
					listaFuncionalidades1.add(funcionalidade9);
					perfil1.setFuncionalidades(listaFuncionalidades1);
					manterPerfilBC.salvar(perfil1, null);

					if (manterUsuarioBC.findAll().isEmpty()) {
						Usuario usuario = new Usuario();
						usuario.setEmail("root@linkedmed.com.br");
						usuario.setSenha("1");
						usuario.setAtivo(true);
						usuario.setDataCadastro(new Date());
						usuario.setDescricao("");
						usuario.setUsuarioCriador(null);
						usuario.setPerfil(perfil);
						manterUsuarioBC.insert(usuario);
						manterPerfilBC.salvar(perfil, usuario);
						Usuario usuario1 = new Usuario();
						usuario1.setEmail("mbacefor@gmail.com");
						usuario1.setSenha("12345");
						usuario1.setAtivo(true);
						usuario1.setDataCadastro(new Date());
						usuario1.setDescricao("");
						usuario1.setUsuarioCriador(null);
						usuario1.setPerfil(perfil1);
						manterUsuarioBC.insert(usuario1);
						manterPerfilBC.salvar(perfil1, usuario1);

					}

				}

				if (manterAreaEspecialidadeBC.findAll().isEmpty()) {
					AreaEspecialidade areaEspecialidade = new AreaEspecialidade();
					areaEspecialidade.setNome("Atendente");
					areaEspecialidade.setAtivo(true);
					manterAreaEspecialidadeBC.salvar(areaEspecialidade, null);

					AreaEspecialidade areaEspecialidade1 = new AreaEspecialidade();
					areaEspecialidade1.setNome("Medico");
					areaEspecialidade1.setAtivo(true);
					manterAreaEspecialidadeBC.salvar(areaEspecialidade1, null);

					AreaEspecialidade areaEspecialidade2 = new AreaEspecialidade();
					areaEspecialidade2.setNome("Dentista");
					areaEspecialidade2.setAtivo(true);
					manterAreaEspecialidadeBC.salvar(areaEspecialidade2, null);

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

	public String getOcultaTAGUsuarioLogado() {
		if (getUsuarioLogado() != null)
			ocultaTAGUsuarioLogado = "hidden";
		else
			ocultaTAGUsuarioLogado = "show";

		return ocultaTAGUsuarioLogado;
	}

	public void setOcultaTAGUsuarioLogado(String ocultaTAGUsuarioLogado) {
		this.ocultaTAGUsuarioLogado = ocultaTAGUsuarioLogado;
	}

	public String getOcultaTAGUsuarioNaoLogado() {
		if (getUsuarioLogado() == null)
			ocultaTAGUsuarioNaoLogado = "hidden";
		else
			ocultaTAGUsuarioNaoLogado = "show";

		return ocultaTAGUsuarioNaoLogado;

	}

	public void setOcultaTAGUsuarioNaoLogado(String ocultaTAGUsuarioNaoLogado) {
		this.ocultaTAGUsuarioNaoLogado = ocultaTAGUsuarioNaoLogado;
	}

}
