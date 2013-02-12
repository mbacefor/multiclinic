/**
 * 
 */
package br.med.multiclinic.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.med.multiclinic.domain.Paciente;
import br.med.multiclinic.domain.Usuario;
import br.med.multiclinic.persistence.PacienteDAO;

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
	
	public void salvar(Paciente paciente, Usuario usuarioLogado) {

		//Fonetizador fonetizador = new Fonetizador();
		paciente.setNomeFonetico((paciente
				.getNome()));

		super.salvar(paciente, usuarioLogado);
	}

}