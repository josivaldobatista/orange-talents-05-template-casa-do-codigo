package br.com.zupacademy.josivaldo.casadocodigo.controllers.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ErroValidacao {

  private Instant timestamp;
  private Integer status;
  private String error;
  private String path;

  private List<CampoMensagem> erros = new ArrayList<>();

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public List<CampoMensagem> getErros() {
    return erros;
  }

  public void addErro(String nomeDoCampo, String mensagem) {
    erros.add(new CampoMensagem(nomeDoCampo, mensagem));
  }

}
