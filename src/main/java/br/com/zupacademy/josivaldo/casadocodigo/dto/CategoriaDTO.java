package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

public class CategoriaDTO {

  @NotBlank
  @UniqueValueValid(domainClass = Categoria.class, fieldName = "nome")
  private String nome;

  @Deprecated
  public CategoriaDTO() {
  }

  public CategoriaDTO(@NotBlank String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public Categoria copyDtoToEntity() {
    return new Categoria(this.nome);
  }
}
