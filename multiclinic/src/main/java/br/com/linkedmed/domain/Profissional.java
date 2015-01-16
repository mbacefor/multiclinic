package br.com.linkedmed.domain;

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

@Entity
public class Profissional {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false, length = 20)
	private String cpf;

	@Column(nullable = false, length = 120)
	private String nome;

	@Column(nullable = false, length = 120)
	private String endereco;

	@Column(nullable = false, length = 20)
	private String telefone;

	@Column(nullable = false, length = 20)
	private String celular;

	@Column(nullable = false, length = 200)
	private String descricao;

	@OneToOne
	private Usuario usuarioCriador;

	@Temporal(TemporalType.TIMESTAMP)
	@Nonnull
	private Date dataCadastro;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	private List<AreaEspecialidade> areasEspecialidade;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<AreaEspecialidade> getAreasEspecialidade() {
		return areasEspecialidade;
	}

	public void setAreasEspecialidade(List<AreaEspecialidade> areasEspecialidade) {
		this.areasEspecialidade = areasEspecialidade;
	}
}
