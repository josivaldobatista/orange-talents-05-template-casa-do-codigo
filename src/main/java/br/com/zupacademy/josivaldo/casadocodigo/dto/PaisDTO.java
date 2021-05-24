package br.com.zupacademy.josivaldo.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.josivaldo.casadocodigo.entities.Pais;
import br.com.zupacademy.josivaldo.casadocodigo.validations.UniqueValueValid;

public class PaisDTO {

  @NotBlank
	@UniqueValueValid(domainClass = Pais.class,fieldName =  "nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
