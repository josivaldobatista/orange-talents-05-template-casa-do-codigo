package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;
import br.com.zupacademy.josivaldo.casadocodigo.validations.CategoriaSalvarValid;

@CategoriaSalvarValid
public class CategoriaDTO {

  @NotBlank
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
