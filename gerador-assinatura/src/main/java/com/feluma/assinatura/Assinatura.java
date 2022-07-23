package com.feluma.assinatura;

import java.awt.event.ActionEvent;

public class Assinatura extends AssinaturaForm {

	private static final long serialVersionUID = 1L;

	@Override
	protected void btnGerarClick(ActionEvent evt) {
     
		String msg = (String) cbxInstituto.getSelectedItem();

		System.out.println(msg);
		
	}

	@Override
	protected void btnLimparClick(ActionEvent evt) {
		txtNome.setText("");
		txtSetor.setText("");
		txtTelefone.setText("");
		txtInstituto.setText("");
		
	}

	@Override
	protected void btnFecharClick(ActionEvent evt) {
		this.setVisible(false);
		this.dispose();
		
	}

}
