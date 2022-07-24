package com.feluma.assinatura.model;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Instituto instituto;
	private String funcao;
	private String telefone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public Instituto getInstituto() {
		return instituto;
	}
	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome);
	}
	
	

}
