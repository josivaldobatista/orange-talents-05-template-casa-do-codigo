package br.com.zupacademy.josivaldo.casadocodigo.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_autor")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @Size(max = 400)
  private String descricao;

  private Instant instanteCriacao = Instant.now();

  @Deprecated
  public Autor() {
  }

  public Autor(@NotBlank String nome, @NotBlank String email, @NotBlank String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return "Autor [descricao=" + descricao + ", email=" + email + ", instanteCriacao=" + instanteCriacao + ", nome="
        + nome + "]";
  }

}
