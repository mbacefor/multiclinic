package br.com.linkedmed.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@NamedQueries({
		@NamedQuery(name = "Profissional.findAll", query = "SELECT c FROM Profissional c"),
		@NamedQuery(name = "Profissional.findByName", query = "SELECT c FROM Profissional c WHERE c.nomeFonetico like :busca"), })
public class Profissional extends Paciente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<AreaEspecialidade> areasEspecialidade;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "profissional")
	@Fetch(FetchMode.SUBSELECT)
	private List<Evento> eventosProfissional;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trabalhador", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<RelacionamentoTrabalha> trabalhaClinica;

	public List<AreaEspecialidade> getAreasEspecialidade() {
		return areasEspecialidade;
	}

	public void setAreasEspecialidade(List<AreaEspecialidade> areasEspecialidade) {
		this.areasEspecialidade = areasEspecialidade;
	}

	public List<Evento> getEventosProfissional() {
		return eventosProfissional;
	}

	public void setEventosProfissional(List<Evento> eventosProfissional) {
		this.eventosProfissional = eventosProfissional;
	}

}
