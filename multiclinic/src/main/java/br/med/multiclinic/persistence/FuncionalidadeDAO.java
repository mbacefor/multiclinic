package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.Funcionalidade;

@PersistenceController
public class FuncionalidadeDAO extends JPACrud<Funcionalidade, Long> {

	private static final long serialVersionUID = 1L;

}