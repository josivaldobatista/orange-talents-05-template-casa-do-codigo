package br.com.zupacademy.josivaldo.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

  Autor findByEmail(String email);
}
