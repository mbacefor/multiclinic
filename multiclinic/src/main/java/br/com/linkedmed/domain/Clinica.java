/**
 * 
 */
package br.com.linkedmed.domain;

import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author fa7bd
 * 
 */
@Entity
public class Clinica {

	final public static int TAMANHO_CNPJ = 14;
	final public static int TAMANHO_DATA = 8;

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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Clinica)) {
			return false;
		}
		Clinica other = (Clinica) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false, length = 256)
	private String nome;

	@Column(nullable = true, length = TAMANHO_CNPJ, unique = true)
	private Long cnpj;

	@Column(nullable = true, length = TAMANHO_DATA, unique = true)
	private Long data;

	@Column(unique = true, nullable = false, length = 256)
	private String logradouro;

	@Column(unique = true, nullable = false, length = 256)
	private String numero;

	@Column(nullable = false, length = 1024)
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Nonnull
	private Date dataCadastro;
	@Column(nullable = false)
	private Boolean situacao;
	@OneToOne
	private Usuario usuarioCriador;

	@OneToMany(mappedBy = "clinica")
	private List<Sala> salas;

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

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	/**
	 * @return the cnpj
	 */
	public Long getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj
	 *            the cnpj to set
	 */
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the tamanhoCnpj
	 */
	public int getTamanhoCnpj() {
		return TAMANHO_CNPJ;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro
	 *            the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the data
	 */
	public Long getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Long data) {
		this.data = data;
	}

	/**
	 * @return the tamanhoData
	 */
	public int getTamanhoData() {
		return TAMANHO_DATA;
	}

}
