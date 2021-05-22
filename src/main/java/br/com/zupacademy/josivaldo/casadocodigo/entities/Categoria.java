package br.com.zupacademy.josivaldo.casadocodigo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

  @OneToOne
  @JoinColumn(name = "livro_id")
  private Livro livro;

  @Deprecated
  public Categoria() {
  }

  public Categoria(@NotBlank String nome, Livro livro) {
    this.nome = nome;
    this.livro = livro;
  }

  @Override
  public String toString() {
    return "Categoria [livro=" + livro + ", nome=" + nome + "]";
  }

}
