package br.med.multiclinic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Email;

import br.med.multiclinic.domain.template.EntidadeGeralTemplate;

@Entity
public class Usuario extends EntidadeGeralTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nome do email
	 */

	@Column(unique = true, nullable = false, length = 150)
	@Email(message = "Formato inválido de e-mail.")
	private String email;

	/**
	 * Nome do senha
	 */
	@Column(length = 12, nullable = false)
	private String senha;

	@ManyToOne
	private Perfil perfil;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + ", perfil="
				+ perfil + ", id=" + id + ", Descricao=" + Descricao
				+ ", dataCadastro=" + dataCadastro + ", ativo=" + ativo + "]";
	}

}
