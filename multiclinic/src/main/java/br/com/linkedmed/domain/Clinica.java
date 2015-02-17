/**
 * 
 */
package br.com.linkedmed.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.linkedmed.domain.template.EntidadeGeralTemplate;

/**
 * @author fa7bd
 * 
 */
@Entity
public class Clinica extends EntidadeGeralTemplate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final public static int TAMANHO_CNPJ = 20;
	final public static int TAMANHO_DATA = 8;
	final public static int TAMANHO_ENDERECO = 255;

	@Column(nullable = true, length = TAMANHO_CNPJ, unique = true)
	private Long cnpj;

	@Column(unique = true, nullable = false, length = 256)
	protected String nome;

	@Column(length = TAMANHO_ENDERECO, nullable = false)
	private String endereco;

	@Column(nullable = true)
	private Double coordX;

	@Column(nullable = true)
	private Double coordY;

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Evento> eventos;

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
	 * @return the tamanhoData
	 */
	public int getTamanhoData() {
		return TAMANHO_DATA;
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

	public Double getCoordX() {
		return coordX;
	}

	public void setCoordX(Double coordX) {
		this.coordX = coordX;
	}

	public Double getCoordY() {
		return coordY;
	}

	public void setCoordY(Double coordY) {
		this.coordY = coordY;
	}

	public int getTamanhoEndereco() {
		return TAMANHO_ENDERECO;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}
