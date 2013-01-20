package br.med.multiclinic.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.med.multiclinic.domain.template.EntidadeGeralTemplate;

@Entity
public class AreaEspecialidade extends EntidadeGeralTemplate implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true, nullable = false, length = 256)
	private String nome;

	@ManyToMany
	private List<Convenio> Convenio;

	@ManyToMany
	private List<Clinica> Clinica;

	@ManyToMany
	private List<Profissional> Profissional;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public List<Convenio> getConvenio() {
		return Convenio;
	}

	public void setConvenio(List<Convenio> convenio) {
		Convenio = convenio;
	}

	public List<Clinica> getClinica() {
		return Clinica;
	}

	public void setClinica(List<Clinica> clinica) {
		Clinica = clinica;
	}

	public List<Profissional> getProfissional() {
		return Profissional;
	}

	public void setProfissional(List<Profissional> profissional) {
		Profissional = profissional;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AreaEspecialidade)) {
			return false;
		}
		AreaEspecialidade other = (AreaEspecialidade) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
