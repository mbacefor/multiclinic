/**
 * 
 */
package br.com.linkedmed.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author fa7bd
 * 
 */
@Entity
public class Convenio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false, length = 256)
	private String nome;
	@Column(nullable = false, length = 1024)
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	@Nonnull
	private Date dataCadastro;
	@Column(nullable = false)
	private Boolean situacao;
	@OneToOne
	private Usuario usuarioCriador;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private List<AreaEspecialidade> areasEspecialidade;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Convenio))
			return false;
		Convenio other = (Convenio) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro
	 *            the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the situacao
	 */
	public Boolean getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao
	 *            the situacao to set
	 */
	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public List<AreaEspecialidade> getAreasEspecialidade() {
		return areasEspecialidade;
	}

	public void setAreasEspecialidade(List<AreaEspecialidade> areasEspecialidade) {
		this.areasEspecialidade = areasEspecialidade;
	}

}
