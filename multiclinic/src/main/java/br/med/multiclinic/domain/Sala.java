package br.med.multiclinic.domain;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false, length = 256)
	private String nome;

	@Column(nullable = false, length = 1024)
	private String descricao;

	@Column(nullable = false)
	private Boolean situacao;

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
		if (!(obj instanceof Sala))
			return false;
		Sala other = (Sala) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Nonnull
	private Date dataConstrucao;

	@Temporal(TemporalType.TIMESTAMP)
	@Nonnull
	private Date dataCadastro;

	@Column(nullable = false)
	private Long banheiro;

	@Column(nullable = false)
	private Long tamanho;

	@OneToOne
	private Usuario usuarioCriador;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private List<Equipamento> equipamentos;
	@ManyToOne()
	private Clinica clinica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getBanheiro() {
		return banheiro;
	}

	public void setBanheiro(Long banheiro) {
		this.banheiro = banheiro;
	}

	public Long getTamanho() {
		return tamanho;
	}

	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}

	public Date getDataConstrucao() {
		return dataConstrucao;
	}

	public void setDataConstrucao(Date dataConstrucao) {
		this.dataConstrucao = dataConstrucao;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
}
