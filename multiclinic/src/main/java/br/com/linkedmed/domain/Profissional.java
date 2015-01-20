package br.com.linkedmed.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Profissional extends Paciente {

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private List<AreaEspecialidade> areasEspecialidade;

	public List<AreaEspecialidade> getAreasEspecialidade() {
		return areasEspecialidade;
	}

	public void setAreasEspecialidade(List<AreaEspecialidade> areasEspecialidade) {
		this.areasEspecialidade = areasEspecialidade;
	}

}
