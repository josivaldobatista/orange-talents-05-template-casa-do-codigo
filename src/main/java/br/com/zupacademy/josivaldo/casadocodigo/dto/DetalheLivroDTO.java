package br.com.zupacademy.josivaldo.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Livro;

public class DetalheLivroDTO {

  private DetalheAutorDTO autor;
  private String titulo;
  private String isbn;
  private Integer paginas;
  private BigDecimal preco;
  private String resumo;
  private String sumario;
  private String dataPublicacao;

  @Deprecated
  public DetalheLivroDTO() {
  }

  public DetalheLivroDTO(Livro livro) {
    autor = new DetalheAutorDTO(livro.getAutor());
    titulo = livro.getTitulo();
    isbn = livro.getIsbn();
    paginas = livro.getNumeroPaginas();
    preco = livro.getPreco();
    resumo = livro.getResumo();
    sumario = livro.getSumario();
    dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public DetalheAutorDTO getAutor() {
    return autor;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getIsbn() {
    return isbn;
  }

  public Integer getPaginas() {
    return paginas;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public String getResumo() {
    return resumo;
  }

  public String getSumario() {
    return sumario;
  }

  public String getDataPublicacao() {
    return dataPublicacao;
  }

}
