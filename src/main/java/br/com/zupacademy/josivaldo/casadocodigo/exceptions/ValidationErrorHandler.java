package br.com.zupacademy.josivaldo.casadocodigo.exceptions;

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
  public ResponseEntity<ValidationError> erroDeValidacao(MethodArgumentNotValidException e, HttpServletRequest request) {
    ValidationError erro = new ValidationError();
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    erro.setTimestamp(Instant.now());
    erro.setStatus(status.value());
    erro.setError("Erro de validação");
    erro.setMessage(e.getMessage());
    erro.setPath(request.getRequestURI());

    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      erro.addError(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return ResponseEntity.status(status).body(erro);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e, HttpServletRequest request) {
    StandardError err = new StandardError();
    HttpStatus status = HttpStatus.BAD_REQUEST;
      err.setTimestamp(Instant.now());
      err.setStatus(status.value());
      err.setError("Bad request");
      err.setMessage(e.getMessage());
      err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
}
