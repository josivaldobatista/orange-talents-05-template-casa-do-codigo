package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Livro;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

public class CategoriaDTO {

  @NotBlank
  @UniqueValueValid(domainClass = Categoria.class, fieldName = "nome")
  private String nome;

  @NotNull
  private Livro livro;

  @Deprecated
  public CategoriaDTO() {
  }

  public CategoriaDTO(@NotBlank String nome, @NotNull Livro livro) {
    this.nome = nome;
    this.livro = livro;
  }

  public String getNome() {
    return nome;
  }

  public Categoria copyDtoToEntity() {
    return new Categoria(this.nome, this.livro);
  }
}
