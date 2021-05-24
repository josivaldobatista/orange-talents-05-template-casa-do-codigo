package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Estado;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Pais;
import br.com.zupacademy.josivaldo.casadocodigo.validations.ExistIdValid;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueEstadoPaisValid;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

@UniqueEstadoPaisValid(domainClass = Estado.class, fieldNameOne = "nome", fieldNameTwo = "id_pais")
public class EstadoDTO {

  @NotBlank
  @UniqueValueValid(domainClass = Estado.class, fieldName = "nome")
  private String nome;

  @NotNull
  @ExistIdValid(domainClass = Pais.class, fieldName = "id")
  private Long id_pais;

  public EstadoDTO(@NotBlank String nome, @NotNull Long id_pais) {
		super();
		this.nome = nome;
		this.id_pais = id_pais;
	}

  @Override
  public String toString() {
    return "NovoEstadoRequest [nome=" + nome + ", id_pais=" + id_pais + "]";
  }

  public Estado toModel(EntityManager manager) {
    return new Estado(nome, manager.find(Pais.class, id_pais));
  }

  public String getNome() {
    return nome;
  }

  public Long getId_pais() {
    return id_pais;
  }

}
