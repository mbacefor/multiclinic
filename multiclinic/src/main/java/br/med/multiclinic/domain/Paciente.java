package br.med.multiclinic.domain;

import java.util.Date;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import br.med.multiclinic.domain.template.EntidadeGeralTemplate;

/*
 * Classe que representa um paciente
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "unicidadePaciente", columnNames = {
		"nomeFonetico", "fone", "sexo", "dataAniversario" }))
public class Paciente extends EntidadeGeralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constantes utilizadas na classe
	 */
	final public static int TAMANHO_NOME = 80;
	final public static int TAMANHO_ENDERECO = 255;
	final public static int TAMANHO_FONE = 15;
	final public static int TAMANHO_CPF = 11;

	@Column(length = TAMANHO_NOME, nullable = false)
	private String nome;

	@Column(length = TAMANHO_NOME + 10, nullable = true)
	private String nomeFonetico;

	@Column(length = TAMANHO_ENDERECO, nullable = false)
	private String endereco;

	@Column(nullable = true, length = TAMANHO_FONE)
	private String fone;

	@Column(nullable = true, length = TAMANHO_FONE)
	private String foneAdicional;

	@Column(nullable = true, length = TAMANHO_CPF, unique = true)
	private Long cpf;

	@Column(nullable = true, length = TAMANHO_NOME)
	private String nomeFoto;

	@Column(nullable = false)
	private Character sexo;

	@Temporal(TemporalType.DATE)
	@Nonnull
	private Date dataAniversario;

	/**
	 * Representa o usuario do sistema que cadastrou o paciente
	 */
	@OneToOne(optional = true)
	private Usuario usuario;

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Paciente)) {
			return false;
		}
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
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
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone
	 *            the fone to set
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the nomeFoto
	 */
	public String getNomeFoto() {
		return nomeFoto;
	}

	/**
	 * @param nomeFoto
	 *            the nomeFoto to set
	 */
	public void setNomeFoto(String nomeFoto) {
		this.nomeFoto = nomeFoto;
	}

	/**
	 * @return the usuarioCadastrador
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuarioCadastrador
	 *            the usuarioCadastrador to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the foneAdicional
	 */
	public String getFoneAdicional() {
		return foneAdicional;
	}

	/**
	 * @param foneAdicional
	 *            the foneAdicional to set
	 */
	public void setFoneAdicional(String foneAdicional) {
		this.foneAdicional = foneAdicional;
	}

	/**
	 * @return the tamanhoNome
	 */
	public int getTamanhoNome() {
		return TAMANHO_NOME;
	}

	/**
	 * @return the tamanhoEndereco
	 */
	public int getTamanhoEndereco() {
		return TAMANHO_ENDERECO;
	}

	/**
	 * @return the tamanhoFone
	 */
	public int getTamanhoFone() {
		return TAMANHO_FONE;
	}

	/**
	 * @return the tamanhoCpf
	 */
	public int getTamanhoCpf() {
		return TAMANHO_CPF;
	}

	/**
	 * @return the sexo
	 */
	public Character getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the dataAniversario
	 */
	public Date getDataAniversario() {
		return dataAniversario;
	}

	/**
	 * @param dataAniversario
	 *            the dataAniversario to set
	 */
	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	/**
	 * @return the nomeFonetico
	 */
	public String getNomeFonetico() {
		return nomeFonetico;
	}

	/**
	 * @param nomeFonetico
	 *            the nomeFonetico to set
	 */
	public void setNomeFonetico(String nomeFonetico) {
		this.nomeFonetico = nomeFonetico;
	}

}