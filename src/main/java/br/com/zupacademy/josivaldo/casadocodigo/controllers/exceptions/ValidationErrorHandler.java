package br.com.zupacademy.josivaldo.casadocodigo.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationErrorHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErroValidacao> erroDeValidacao(MethodArgumentNotValidException e, HttpServletRequest request) {
    ErroValidacao erro = new ErroValidacao();
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    erro.setTimestamp(Instant.now());
    erro.setStatus(status.value());
    erro.setError("Erro de validação");
    erro.setPath(request.getRequestURI());

    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      erro.addErro(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return ResponseEntity.status(status).body(erro);
  }
}
