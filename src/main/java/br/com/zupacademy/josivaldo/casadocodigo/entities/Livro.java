package br.com.zupacademy.josivaldo.casadocodigo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "tb_livro")
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String titulo;

  @Size(max = 500)
  @NotBlank
  private String resumo;

  @Column(columnDefinition = "TEXT")
  private String sumario;

  @NotNull
  private BigDecimal preco;

  @NotNull
  private Integer numeroPaginas;

  @NotBlank
  private String isbn;

  @Future
  @NotNull
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
  private @Future @NotNull LocalDate dataPublicacao;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  @NotNull
  private Categoria categoria;

  @ManyToOne
  @JoinColumn(name = "autor_id")
  @NotNull
  private Autor autor;

  @Deprecated
  public Livro() {
  }

  public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
      @NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank String isbn,
      @Future @NotNull LocalDate dataPublicacao, @NotNull @Valid Autor autor, @NotNull @Valid Categoria categoria) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroPaginas = numeroPaginas;
    this.isbn = isbn;
    this.dataPublicacao = dataPublicacao;
    this.autor = autor;
    this.categoria = categoria;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  @Override
  public String toString() {
    return "Livro [autor=" + autor + ", categoria=" + categoria + ", dataPublicacao=" + dataPublicacao + ", id=" + id
        + ", isbn=" + isbn + ", numeroPaginas=" + numeroPaginas + ", preco=" + preco + ", resumo=" + resumo
        + ", sumario=" + sumario + ", titulo=" + titulo + "]";
  }

}
