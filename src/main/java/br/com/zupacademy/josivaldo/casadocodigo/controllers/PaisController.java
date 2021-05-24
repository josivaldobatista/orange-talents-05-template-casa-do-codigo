package br.com.zupacademy.josivaldo.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.josivaldo.casadocodigo.dto.PaisDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Pais;

@RestController
@RequestMapping("/paises")
public class PaisController {

  @PersistenceContext
  private EntityManager manager;

  @PostMapping
	@Transactional
	public String criaPais(@RequestBody @Valid PaisDTO dto) {
		Pais novoPais = new Pais(dto.getNome());
		manager.persist(novoPais);
		return novoPais.toString();
	}
}
