package br.com.zupacademy.josivaldo.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

  @Query("select c from Categoria c where c.nome = :nome")
  Categoria findByNomeCategoria(String nome);

}
