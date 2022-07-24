package com.feluma.assinatura;

import javax.swing.SwingUtilities;

public class Aplicacao {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			Gerador assinatura = new Gerador();
			
			assinatura.setVisible(true);
			
		});

	}

}
