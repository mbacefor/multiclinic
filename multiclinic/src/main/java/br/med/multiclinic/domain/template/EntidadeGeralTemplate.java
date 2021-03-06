package br.med.multiclinic.domain.template;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.med.multiclinic.domain.Usuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class EntidadeGeralTemplate implements Serializable {

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeGeralTemplate other = (EntidadeGeralTemplate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDataCadastroFormatada() {
		if (dataCadastro == null)
			return null;
		SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataCadastroFormatada = sDF.format(dataCadastro);
		return dataCadastroFormatada;

	}

	public void setDataCadastroFormatada(String dataCadastroFormatada) {
		this.dataCadastroFormatada = dataCadastroFormatada;
	}

}
