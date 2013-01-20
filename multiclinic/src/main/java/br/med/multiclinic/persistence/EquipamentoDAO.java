package br.med.multiclinic.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.med.multiclinic.domain.Equipamento;

@PersistenceController
public class EquipamentoDAO extends JPACrud<Equipamento, Long> {

	private static final long serialVersionUID = 1L;

}