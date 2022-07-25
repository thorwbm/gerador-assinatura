package com.feluma.assinatura.model;

import java.awt.Color;

public enum Cor {

	AZUL(14,65,148),
	AMARELO(248,208,63),
	DOURADO(132,117,77),
	LARANJA(250,188,67),
	VERDE(7,176,156),
	PRETO(0,0,0);
	
	;
	
	private int r;
	private int g;
	private int b;
	
	Cor(int red, int green, int blue){
		this.r = red;
		this.g = green;
		this.b = blue;
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}
	
	public Color getCor() {
		return new Color(r,g,b);
	}
}
