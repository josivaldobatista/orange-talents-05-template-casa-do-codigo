package br.com.zupacademy.josivaldo.casadocodigo.validations;

import javax.validation.Payload;

public @interface ExistIdValid {

  String message() default "{exists.id}";

  Class<?>[] groups() default {}; // <- Aplica a validação a um grupo específico (ex. ADMIN, USUARIO)

  Class<? extends Payload>[] payload() default {}; // Mandar informação a mais no payload (pra dentro da validação)

  String fieldName();

  Class<?> domainClass();
}
