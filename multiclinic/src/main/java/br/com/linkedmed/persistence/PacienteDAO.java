package br.com.linkedmed.persistence;

import java.util.List;

import br.com.linkedmed.domain.Paciente;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class PacienteDAO extends JPACrud<Paciente, Long> {

	private static final long serialVersionUID = 1L;

	public List<Paciente> buscaFoneticaNome(String busca) {
		List<Paciente> pacientes = null;
		try {
			List<Paciente> resultList = (List<Paciente>) getEntityManager()
					.createNamedQuery("Paciente.findByName")
					.setParameter("busca", "%" + busca + "%").getResultList();
			pacientes = resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pacientes;
	}
}