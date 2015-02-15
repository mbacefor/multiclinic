package br.com.linkedmed.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Profissional extends Paciente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<AreaEspecialidade> areasEspecialidade;

	public List<AreaEspecialidade> getAreasEspecialidade() {
		return areasEspecialidade;
	}

	public void setAreasEspecialidade(List<AreaEspecialidade> areasEspecialidade) {
		this.areasEspecialidade = areasEspecialidade;
	}

}
