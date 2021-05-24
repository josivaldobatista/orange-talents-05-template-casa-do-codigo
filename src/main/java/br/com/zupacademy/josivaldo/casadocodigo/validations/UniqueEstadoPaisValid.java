package br.com.zupacademy.josivaldo.casadocodigo.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { UniqueEstadoPaisValidator.class })
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEstadoPaisValid {
  
  String message() default "{erro.estado.pais.unico}";

  Class<?>[] groups() default {}; // <- Aplica a validação a um grupo específico (ex. ADMIN, USUARIO)

  Class<? extends Payload>[] payload() default {}; // Mandar informação a mais no payload (pra dentro da validação)

  String fieldNameOne();
  String fieldNameTwo();
  Class<?> domainClass();
}
