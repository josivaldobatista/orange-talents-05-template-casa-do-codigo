package br.com.zupacademy.josivaldo.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.josivaldo.casadocodigo.dto.EstadoDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Estado;

@RestController
@RequestMapping("/estados")
public class EstadoController {

  @PersistenceContext
  private EntityManager manager;

  /**
   * Para salvar um Estado devemos ter algum um País já salvo, portanto caso de
   * algum erro de validação por não ter um pais, tente salvar primeiro um País
   * primeiro.
   */
  @PostMapping
  @Transactional
  public String salvar(@RequestBody @Valid EstadoDTO dto) {
    Estado estado = dto.toModel(manager);
    manager.persist(estado);
    return estado.toString();
  }
}
