package br.com.linkedmed.persistence;

import java.util.List;

import br.com.linkedmed.domain.Profissional;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ProfissionalDAO extends JPACrud<Profissional, Long> {

	private static final long serialVersionUID = 1L;

	public List<Profissional> buscaFoneticaNome(String query) {
		List<Profissional> profissionais = null;
		try {
			List<Profissional> resultList = (List<Profissional>) getEntityManager()
					.createNamedQuery("Profissional.findByName")
					.setParameter("busca", "%" + query + "%").getResultList();
			profissionais = resultList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profissionais;
	}

}