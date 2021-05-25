package br.com.zupacademy.josivaldo.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.josivaldo.casadocodigo.dto.ClienteDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Cliente;

@RestController
@RequestMapping
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@PostMapping("/clientes")
	public String salvar(@RequestBody @Valid ClienteDTO dto) {
		Cliente cliente = dto.toModel(manager);
		manager.persist(cliente);
		return dto.toString();
	}
}
