package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.josivaldo.casadocodigo.controllers.validations.AutorSalvarValid;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;

@AutorSalvarValid
public class AutorDTO {

  @NotBlank
  private String nome;

  @NotBlank
  @Email(message = "Informe um E-mail válido")
  private String email;

  @NotBlank
  @Size(max = 400)
  private String descricao;

  public AutorDTO(@NotBlank String nome, @NotBlank @Email String email, 
    @NotBlank @Size(max = 400) String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  public Autor copyDtoToMOdel() {
    return new Autor(this.nome, this.email, this.descricao);
  }

  public String getEmail() {
    return email;
  }

}
