/**
 * 
 */
package br.com.linkedmed.view.manterclinica;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.linkedmed.business.ManterClinicaBC;
import br.com.linkedmed.business.ManterProfissionalBC;
import br.com.linkedmed.domain.Clinica;
import br.com.linkedmed.domain.Profissional;
import br.com.linkedmed.domain.Relacionamento;
import br.com.linkedmed.domain.RelacionamentoTrabalha;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.util.FacesBean;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;

/**
 * Manager Bean associado a tela de edição do clínica
 * 
 * @author fa7bd
 * 
 */

@ViewController
@javax.enterprise.context.SessionScoped
public class EditarClinicaMB extends FacesBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NOME_MANAGER_BEAN = "editarClinicaMB";
	public static final String CAMINHO_TELA = "/pages/manterclinica/editarClinica.xhtml";

	private Clinica clinica = new Clinica();

	private Profissional profissional = null;

	private RelacionamentoTrabalha profissionalSelecionado = null;

	@Inject
	private ManterClinicaBC manterClinicaBC;

	@Inject
	private ManterProfissionalBC manterProfissionalBC;

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	/*
	 * Atributo que conterá as informações das clínicas
	 */

	/**
	 * Metodo que inicia a nova clínica
	 * 
	 * @return
	 */
	public String prepararNovo() {
		String retorno = null;
		try {
			Clinica novaClinica = new Clinica();
			EditarClinicaMB editarClinicaMB = (EditarClinicaMB) getBean(EditarClinicaMB.NOME_MANAGER_BEAN);
			editarClinicaMB.setClinica(novaClinica);
			retorno = EditarClinicaMB.CAMINHO_TELA;

		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que salva uma clínica
	 * 
	 * @return
	 */
	@Transactional
	public String salvar() {
		String retorno = null;
		try {

			Usuario usuarioLogado = obterUsuarioLogado();
			manterClinicaBC.salvar(clinica, usuarioLogado);
			ListarClinicaMB listarClinicaMB = (ListarClinicaMB) getBean(ListarClinicaMB.NOME_MANAGER_BEAN);
			List<Clinica> lista = manterClinicaBC.obterTodos();
			listarClinicaMB.setLista(lista);
			retorno = ListarClinicaMB.CAMINHO_TELA;
			info("Clinica salva com sucesso!");
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela a edição de uma clinica
	 * 
	 * @return
	 */
	public String cancelar() {
		String retorno = null;
		try {
			retorno = EditarClinicaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela a edição de uma clinica
	 * 
	 * @return
	 */
	public String excluir() {
		String retorno = null;
		try {
			if (clinica != null && clinica.getTrabalhaClinica() != null
					&& profissionalSelecionado != null) {
				clinica.getTrabalhaClinica().remove(profissionalSelecionado);

			}
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	/**
	 * Metodo que cancela a edição de uma clinica
	 * 
	 * @return
	 */
	public String adicionarAtendente() {
		String retorno = null;
		try {

			if (profissional != null) {
				RelacionamentoTrabalha relacionamento = new RelacionamentoTrabalha();
				relacionamento.setEmpregador(clinica);
				relacionamento.setTrabalhador(profissional);
				relacionamento.setNome("TRABALHA");
				relacionamento.setAtivo(true);
				relacionamento.setUsuarioCriador(obterUsuarioLogado());
				if (clinica.getMeusRelacionamentos() != null)
					clinica.getMeusRelacionamentos().add(relacionamento);
				else {
					clinica.setMeusRelacionamentos(new ArrayList<Relacionamento>());
					clinica.getMeusRelacionamentos().add(relacionamento);
				}
			}
			retorno = EditarClinicaMB.CAMINHO_TELA;
		} catch (Exception e) {
			error(e.getMessage());
		}
		return retorno;
	}

	public List<Profissional> completeProfissional(String query) {
		List<Profissional> allProfissionais = manterProfissionalBC
				.buscaFoneticaNome(query);
		return allProfissionais;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public RelacionamentoTrabalha getProfissionalSelecionado() {
		return profissionalSelecionado;
	}

	public void setProfissionalSelecionado(
			RelacionamentoTrabalha profissionalSelecionado) {
		this.profissionalSelecionado = profissionalSelecionado;
	}

}
