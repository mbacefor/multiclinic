/**
 * 
 */
package br.com.linkedmed.business;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.com.linkedmed.domain.Paciente;
import br.com.linkedmed.domain.Usuario;
import br.com.linkedmed.persistence.PacienteDAO;
import br.com.linkedmed.util.Fonetizador;

/**
 * @author fa7bd
 * 
 */
@BusinessController
public class PacienteBC extends GenericoBC<Paciente, Long, PacienteDAO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	Fonetizador fonetizador;

	public void salvar(Paciente paciente, Usuario usuarioLogado) {
		paciente.setNomeFonetico(fonetizador.fornetizarComDicionario((paciente
				.getNome())));
		paciente.getCpfNulo();
		super.salvar(paciente, usuarioLogado);
	}

	public List<Paciente> buscaFoneticaNome(String busca) {
		busca = fonetizador.fornetizarComDicionario(busca);
		return ((PacienteDAO) getDelegate()).buscaFoneticaNome(busca);
	}

}