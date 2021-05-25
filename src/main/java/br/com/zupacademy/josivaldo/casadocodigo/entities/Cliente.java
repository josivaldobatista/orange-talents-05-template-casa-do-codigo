package br.com.zupacademy.josivaldo.casadocodigo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
  @Email(message = "Informe um E-mail válido")
	private String email;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String cidade;
	
	@ManyToOne
	private Estado estado;
	
	@ManyToOne
	@NotNull
	private Pais pais;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String complemento;

	public Cliente(@NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank @Email(message = "Informe um E-mail válido") String email, @NotBlank String telefone,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String cidade, Pais pais, @NotBlank String cep,
			@NotBlank String complemento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.documento = documento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.pais = pais;
		this.cep = cep;
		this.complemento = complemento;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public String getCep() {
		return cep;
	}

	public String getComplemento() {
		return complemento;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", telefone=" + telefone
				+ ", documento=" + documento + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado
				+ ", pais=" + pais + ", cep=" + cep + ", complemento=" + complemento + "]";
	}
	
}
