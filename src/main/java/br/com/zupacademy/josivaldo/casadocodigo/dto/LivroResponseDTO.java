package br.com.zupacademy.josivaldo.casadocodigo.dto;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Livro;

public class LivroResponseDTO {

  private Long id;
  private String titulo;

  public LivroResponseDTO() {
  }

  public LivroResponseDTO(Livro livro) {
    this.id = livro.getId();
    this.titulo = livro.getTitulo();
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  @Override
  public String toString() {
    return "LivroResponseDTO [id=" + id + ", titulo=" + titulo + "]";
  }

}
