package com.feluma.assinatura;

import java.awt.event.ActionEvent;
import com.feluma.assinatura.gerador.GeradorAssinatura;
import com.feluma.assinatura.model.Instituto;
import com.feluma.assinatura.model.Pessoa;

public class Gerador extends GeradorForm {

	private static final long serialVersionUID = 1L;

	@Override
	protected void btnGerarClick(ActionEvent evt) {
     
		String msg = (String) cbxInstituto.getSelectedItem();
		
		GeradorAssinatura assinatura = new GeradorAssinatura();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(txtNome.getText());
		pessoa.setTelefone(txtTelefone.getText());
		pessoa.setFuncao(txtFuncao.getText());
		
		if(msg =="CSC") {
			pessoa.setInstituto(Instituto.CSC);
		} 
        if (msg == "TEATRO"){
		    pessoa.setInstituto(Instituto.TEATRO);		    
		}

        if (msg == "IPG"){
		    pessoa.setInstituto(Instituto.IPG);		    
		}

        if (msg == "HUCM"){
		    pessoa.setInstituto(Instituto.HUCM);		    
		}
		
        
		assinatura.criarAssinatura(pessoa);
		
	}

	@Override
	protected void btnLimparClick(ActionEvent evt) {
		txtNome.setText("");
		txtFuncao.setText("");
		txtTelefone.setText("");
		txtInstituto.setText("");
		
	}

	@Override
	protected void btnFecharClick(ActionEvent evt) {
		this.setVisible(false);
		this.dispose();
		
	}

}
