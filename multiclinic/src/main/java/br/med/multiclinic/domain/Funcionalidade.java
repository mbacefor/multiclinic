package br.med.multiclinic.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.med.multiclinic.domain.template.EntidadeGeralTemplate;

@Entity
public class Funcionalidade extends EntidadeGeralTemplate implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false, length = 256)
	protected String nome;

	@ManyToMany
	private List<Perfil> perfis;

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
