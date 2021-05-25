package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Estado;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Pais;
import br.com.zupacademy.josivaldo.casadocodigo.validations.ExistIdValid;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueEstadoPaisValid;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

@UniqueEstadoPaisValid(domainClass = Estado.class, fieldNameOne = "nome", fieldNameTwo = "pais_id")
public class EstadoDTO {

	@NotBlank
	@UniqueValueValid(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	@ExistIdValid(domainClass = Pais.class, fieldName = "id")
	private Long pais_id;

	public EstadoDTO(@NotBlank String nome, @NotNull Long pais_id) {
		this.nome = nome;
		this.pais_id = pais_id;
	}

	@Override
	public String toString() {
		return "NovoEstadoRequest [nome=" + nome + ", pais_id=" + pais_id + "]";
	}

	public Estado toModel(EntityManager manager) {
		return new Estado(nome, manager.find(Pais.class, pais_id));
	}

	public String getNome() {
		return nome;
	}

	public Long getPais_id() {
		return pais_id;
	}

}
