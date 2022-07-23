package com.feluma.assinatura;

import javax.swing.SwingUtilities;

public class Aplicacao {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			Assinatura assinatura = new Assinatura();
			
			assinatura.setVisible(true);
			
		});

	}

}
