package br.com.linkedmed.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class RelacionamentoTrabalha extends Relacionamento {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne()
	private Clinica empregador;

	@ManyToOne()
	private Profissional trabalhador;

	public Clinica getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Clinica empregador) {
		setOrigem(empregador);
		this.empregador = empregador;
	}

	public Profissional getTrabalhador() {
		setDestino(trabalhador);
		return trabalhador;
	}

	public void setTrabalhador(Profissional trabalhador) {
		this.trabalhador = trabalhador;
	}

}
