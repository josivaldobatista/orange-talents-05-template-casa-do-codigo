package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Livro;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

public class AutorDTO {

  @NotBlank
  private String nome;

  @NotBlank
  @Email(message = "Informe um E-mail válido")
  @UniqueValueValid(domainClass = Autor.class, fieldName = "email")
  private String email;

  @NotBlank
  @Size(max = 400)
  private String descricao;

  @NotNull
  private Livro livro;

  public AutorDTO(@NotBlank String nome, @NotBlank @Email(message = "Informe um E-mail válido") 
    String email, @NotBlank @Size(max = 400) String descricao, @NotNull Livro livro) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
    this.livro = livro;
  }

  public Autor copyDtoToMOdel() {
    return new Autor(nome, email, descricao, livro);
  }

  public String getEmail() {
    return email;
  }

}
