package br.com.zupacademy.josivaldo.casadocodigo.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.josivaldo.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.josivaldo.casadocodigo.entities.Autor;
import br.com.zupacademy.josivaldo.casadocodigo.exceptions.CampoMensagem;
import br.com.zupacademy.josivaldo.casadocodigo.repositories.AutorRepository;

public class AutorSalvarValidator implements ConstraintValidator<AutorSalvarValid, AutorDTO> {

  @Autowired
  private AutorRepository repository;

  @Override
  public void initialize(AutorSalvarValid ann) {
  }

  @Override
  public boolean isValid(AutorDTO dto, ConstraintValidatorContext context) {
    List<CampoMensagem> list = new ArrayList<>();

    Autor autor = repository.findByEmail(dto.getEmail());

    if (autor != null) {
      list.add(new CampoMensagem("email", "Email existente na base de dados"));
    }

    for (CampoMensagem campoMensagem : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(campoMensagem.getMensagem())
          .addPropertyNode(campoMensagem.getCampoMensagem()).addConstraintViolation();
    }

    return list.isEmpty();
  }

}