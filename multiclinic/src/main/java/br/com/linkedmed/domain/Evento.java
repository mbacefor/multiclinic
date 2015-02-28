package br.com.linkedmed.domain;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.linkedmed.domain.template.EntidadeGeralTemplate;

@Entity
public class Evento extends EntidadeGeralTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Profissional profissional;

	@ManyToOne
	private Clinica clinica;

	@ManyToOne
	private Paciente paciente;

	@Nonnull
	protected Date dataInicio;

	@Nonnull
	protected Date dataFim;

	@Column(nullable = false, length = 256)
	protected String nome;

	@Column(nullable = true, length = 256)
	protected String estilo;

	@Column(nullable = true)
	protected Double valor;

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}