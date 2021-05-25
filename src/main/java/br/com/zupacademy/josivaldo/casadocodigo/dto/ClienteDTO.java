package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Cliente;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Estado;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Pais;
import br.com.zupacademy.josivaldo.casadocodigo.validations.ExistIdValid;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

public class ClienteDTO {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
  @Email(message = "Informe um E-mail válido")
  @UniqueValueValid(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	@UniqueValueValid(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExistIdValid(domainClass = Estado.class, fieldName = "id")
	private Long estado_id;
	
	@NotNull
	@ExistIdValid(domainClass = Pais.class, fieldName = "id")
	private Long pais_id;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String complemento;

	@Deprecated
	public ClienteDTO() {
	}

	public ClienteDTO(@NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank @Email(message = "Informe um E-mail válido") String email, @NotBlank String telefone,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String cidade, Long estado_id, Long pais_id,
			@NotBlank String cep, @NotBlank String complemento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.documento = documento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado_id = estado_id;
		this.pais_id = pais_id;
		this.cep = cep;
		this.complemento = complemento;
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

	public Long getEstado_id() {
		return estado_id;
	}

	public Long getPais_id() {
		return pais_id;
	}

	public String getCep() {
		return cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public Cliente toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, pais_id);
		Cliente cliente = new Cliente(nome, sobrenome, email, telefone, documento, endereco, cidade, pais, cep, complemento);
		if (estado_id != null) {
			cliente.setEstado(manager.find(Estado.class, estado_id));
		}
		return cliente;
	}

	
}
