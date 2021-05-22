package br.com.zupacademy.josivaldo.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Livro;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

public class LivroDTO {

  @NotBlank
  @UniqueValueValid(domainClass = Livro.class, fieldName = "titulo")
  private String titulo;

  @Size(max = 500)
  @NotBlank
  private String resumo;

  @Column(columnDefinition = "TEXT")
  private String sumario;

  @NotNull
  @Size(min = 20)
  private BigDecimal preco;

  @NotNull
  @Size(min = 100)
  private Integer numPaginas;

  @NotBlank
  @UniqueValueValid(domainClass = Livro.class, fieldName = "isbn")
  private String isbn;

  @Future
  private Instant dataPublicacao;

  @NotNull
  private Categoria categoria;

  @NotNull
  private Autor autor;

  @Deprecated
  public LivroDTO() {
  }



}
