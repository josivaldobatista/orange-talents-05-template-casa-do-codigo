package br.com.zupacademy.josivaldo.casadocodigo.dto;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;

public class DetalheAutorDTO {

  private String nome;
  private String descricao;

  public DetalheAutorDTO(Autor autor) {
    nome = autor.getNome();
    descricao = autor.getDescricao();
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

}
