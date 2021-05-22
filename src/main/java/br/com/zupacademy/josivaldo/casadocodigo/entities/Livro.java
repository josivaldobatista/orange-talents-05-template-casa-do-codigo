package br.com.zupacademy.josivaldo.casadocodigo.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
  @Size(min = 20)
  private BigDecimal preco;

  @NotNull
  @Size(min = 100)
  private Integer numPaginas;

  @NotBlank
  private String isbn;

  @Future
  private Instant dataPublicacao;

  @NotNull
  @OneToOne(mappedBy = "livro")
  private Categoria categoria;

  @NotNull
  @OneToOne(mappedBy = "livro")
  private Autor autor;

  @Deprecated
  public Livro() {
  }

  public Livro(Long id, @NotBlank String titulo, @Size(max = 500) @NotBlank String resumo, String sumario,
      @NotNull @Size(min = 20) BigDecimal preco, @NotNull @Size(min = 100) Integer numPaginas, @NotBlank String isbn,
      @Future Instant dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
    this.id = id;
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numPaginas = numPaginas;
    this.isbn = isbn;
    this.dataPublicacao = dataPublicacao;
    this.categoria = categoria;
    this.autor = autor;
  }

}
