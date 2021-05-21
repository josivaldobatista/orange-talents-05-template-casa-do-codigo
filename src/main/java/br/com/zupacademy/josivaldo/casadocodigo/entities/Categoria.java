package br.com.zupacademy.josivaldo.casadocodigo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  @Deprecated
  public Categoria() {
  }

  public Categoria(@NotBlank String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "Categoria [nome=" + nome + "]";
  }

}
