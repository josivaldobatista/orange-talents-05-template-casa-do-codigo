package br.com.zupacademy.josivaldo.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.josivaldo.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;
import br.com.zupacademy.josivaldo.casadocodigo.repositories.AutorRepository;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

  @Autowired
  private AutorRepository repository;

  @PostMapping
  @Transactional
  public String salvar(@RequestBody @Valid AutorDTO dto) {
    Autor autor = dto.toModel();
    repository.save(autor);
    return autor.toString();
  }
}
