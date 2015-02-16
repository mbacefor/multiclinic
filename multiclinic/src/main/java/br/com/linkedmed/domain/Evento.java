package br.com.linkedmed.domain;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.linkedmed.domain.template.EntidadeGeralTemplate;

@Entity
public class Evento extends EntidadeGeralTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	private Profissional profissional;

	@OneToOne
	private Clinica clinica;

	@Nonnull
	protected Date dataInicio;

	@Nonnull
	protected Date dataFim;

	@Column(nullable = false, length = 256)
	protected String nome;

	@Column(nullable = false, length = 256)
	protected String estilo;

}