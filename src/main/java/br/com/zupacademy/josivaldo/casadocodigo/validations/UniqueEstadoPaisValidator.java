package br.com.zupacademy.josivaldo.casadocodigo.validations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class UniqueEstadoPaisValidator implements ConstraintValidator<UniqueEstadoPaisValid, Object> {

  @PersistenceContext
  private EntityManager manager;

  private String fieldNameOne;
  private String fieldNameTwo;
  private Class<?> klass;

  @Override
  public void initialize(UniqueEstadoPaisValid uniqueEstadoPaisValid) {
    fieldNameOne = uniqueEstadoPaisValid.fieldNameOne();
    fieldNameTwo = uniqueEstadoPaisValid.fieldNameTwo();
    klass = uniqueEstadoPaisValid.domainClass();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    Query query = manager.createQuery(
        "select 1 from " + klass.getName() + " c where " + fieldNameOne + "=:nome and c.pais.id =:id_pais");

    String nome = (String) new BeanWrapperImpl(value).getPropertyValue(fieldNameOne);
    query.setParameter("nome", nome);

    Long id_pais = (Long) new BeanWrapperImpl(value).getPropertyValue(fieldNameTwo);
    query.setParameter("id_pais", id_pais);

    return query.getResultList().isEmpty();
  }

}
