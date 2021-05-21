package br.com.zupacademy.josivaldo.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.josivaldo.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;
import br.com.zupacademy.josivaldo.casadocodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

  @Autowired
  private CategoriaRepository repository;
  
  @Transactional
  @PostMapping
  public String salvar(@RequestBody @Valid CategoriaDTO dto) {
    Categoria categoria = dto.copyDtoToEntity();
    repository.save(categoria);
    return categoria.toString();
  }
}
