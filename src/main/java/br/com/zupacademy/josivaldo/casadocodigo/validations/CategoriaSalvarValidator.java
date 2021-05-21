package br.com.zupacademy.josivaldo.casadocodigo.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.josivaldo.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Categoria;
import br.com.zupacademy.josivaldo.casadocodigo.exceptions.CampoMensagem;
import br.com.zupacademy.josivaldo.casadocodigo.repositories.CategoriaRepository;

public class CategoriaSalvarValidator implements ConstraintValidator<CategoriaSalvarValid, CategoriaDTO> {

  @Autowired
  private CategoriaRepository repository;

  @Override
  public void initialize(CategoriaSalvarValid ann) {
  }

  @Override
  public boolean isValid(CategoriaDTO dto, ConstraintValidatorContext context) {
    List<CampoMensagem> list = new ArrayList<>();

    Categoria categoria = repository.findByNomeCategoria(dto.getNome());

    if (categoria != null) {
      list.add(new CampoMensagem("nome", "Categoria já existente na base de dados"));
    }

    for (CampoMensagem campoMensagem : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(campoMensagem.getMensagem())
          .addPropertyNode(campoMensagem.getCampoMensagem()).addConstraintViolation();
    }

    return list.isEmpty();
  }

}