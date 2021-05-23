package br.com.zupacademy.josivaldo.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Livro;
import br.com.zupacademy.josivaldo.casadocodigo.validations.ExistIdValid;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

public class LivroDTO {

  @NotBlank
	@UniqueValueValid(domainClass = Livro.class,fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@Min(100)
	private int numeroPaginas;

	@NotBlank
	@UniqueValueValid(domainClass = Livro.class,fieldName = "isbn")
	private String isbn;

	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	@ExistIdValid(domainClass = Categoria.class, fieldName = "id")
	private Long categoria_id;

	@NotNull
	@ExistIdValid(domainClass = Autor.class, fieldName = "id")
	private Long autor_id;

	public LivroDTO(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotNull Long categoria_id,
			@NotNull Long autor_id) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoria_id = categoria_id;
		this.autor_id = autor_id;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, autor_id);
		@NotNull Categoria categoria = manager.find(Categoria.class, categoria_id);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
				dataPublicacao, autor, categoria);
	}

}
