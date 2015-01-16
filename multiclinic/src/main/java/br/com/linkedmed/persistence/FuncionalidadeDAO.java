package br.com.linkedmed.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.linkedmed.domain.Funcionalidade;

@PersistenceController
public class FuncionalidadeDAO extends JPACrud<Funcionalidade, Long> {

	private static final long serialVersionUID = 1L;

}