package com.feluma.assinatura.model;

public enum Instituto {

	CSC("Centro Corporativo", "FELUMA", "www.feluma.org.br"),
	IPG("Centro Corporativo", "CMMG", "https://pos.cmmg.edu.br/"),
	AMBULATORIO("Centro Corporativo", "FELUMA", "www.feluma.org.br"),
	TEATRO("Teatro Feluma", "TEATRO", "https://teatrofeluma.org.br/"),
	HUCM("Hospital Universitario Ciencias Medicas", "CMMG", "www.feluma.org.br");
	
	private String nome;
	private String logo;
	private String site;
	
	Instituto(String nome, String logo, String site){
		this.nome = nome;
		this.logo = logo;
		this.site = site;
	}

	public String getNome() {
		return nome;
	}

	public String getLogo() {
		return logo;
	}

	public String getSite() {
		return site;
	}
	
	
	
}
