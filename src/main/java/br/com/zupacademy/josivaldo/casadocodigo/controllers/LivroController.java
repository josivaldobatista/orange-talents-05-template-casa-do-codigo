package br.com.zupacademy.josivaldo.casadocodigo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.josivaldo.casadocodigo.dto.LivroDTO;
import br.com.zupacademy.josivaldo.casadocodigo.dto.LivroResponseDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Livro;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

  @PersistenceContext
  private EntityManager manager;

  @PostMapping
  @Transactional
  public String salvar(@RequestBody @Valid LivroDTO dto) {
    Livro livro = dto.toModel(manager);
    manager.persist(livro);
    return livro.toString();
  }

  @GetMapping
  @Transactional(readOnly = true)
  public List<LivroResponseDTO> buscarTodos() {
    return manager.createQuery("select l from Livro l", Livro.class)
      .getResultStream().map(LivroResponseDTO::new).collect(Collectors.toList());
  }

}
