package br.com.zupacademy.josivaldo.casadocodigo.controllers.exceptions;

public class CampoMensagem {

  private String campoMensagem;
  private String mensagem;

  public CampoMensagem(String campoMensagem, String mensagem) {
    this.campoMensagem = campoMensagem;
    this.mensagem = mensagem;
  }

  public String getCampoMensagem() {
    return campoMensagem;
  }

  public String getMensagem() {
    return mensagem;
  }

}
