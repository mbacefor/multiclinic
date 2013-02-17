/**
 * 
 */
package br.med.multiclinic.business;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.med.multiclinic.domain.Paciente;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.persistence.PacienteDAO;
import br.med.multiclinic.util.Fonetizador;

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

		super.salvar(paciente, usuarioLogado);
	}

}