package br.com.zupacademy.josivaldo.casadocodigo.controllers.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AutorSalvarValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AutorSalvarValid {

  String message() default "Erro de validação";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
