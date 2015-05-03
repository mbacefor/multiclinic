package br.com.linkedmed.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.linkedmed.domain.template.EntidadeGeralTemplate;

@Entity
public class Relacionamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;
	@Column(nullable = true, length = 1024)
	protected String Descricao;
	@Temporal(TemporalType.TIMESTAMP)
	@Nonnull
	protected Date dataCadastro;
	@Column(nullable = false)
	protected Boolean ativo;
	@OneToOne
	protected Usuario usuarioCriador;
	@Transient
	private String dataCadastroFormatada;

	@Column(nullable = false, length = 256)
	private String nome;

	@ManyToOne()
	private EntidadeGeralTemplate origem;
	
	@ManyToOne()
	private EntidadeGeralTemplate destino;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EntidadeGeralTemplate getDestino() {
		return destino;
	}

	public void setDestino(EntidadeGeralTemplate destino) {
		this.destino = destino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public String getDataCadastroFormatada() {
		if (dataCadastro == null)
			return null;
		SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataCadastroFormatada = sDF.format(dataCadastro);
		return dataCadastroFormatada;

	}

	public EntidadeGeralTemplate getOrigem() {
		return origem;
	}

	public void setOrigem(EntidadeGeralTemplate origem) {
		this.origem = origem;
	}

}
