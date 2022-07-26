package com.feluma.assinatura;

import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.feluma.assinatura.gerador.GeradorAssinatura;
import com.feluma.assinatura.model.Instituto;
import com.feluma.assinatura.model.Pessoa;

public class Gerador extends GeradorForm {

	private static final long serialVersionUID = 1L;
	String saida = null;

	@Override
	protected void btnGerarClick(ActionEvent evt) {
     
		GeradorAssinatura assinatura = new GeradorAssinatura();
		String instituto = (String) cbxInstituto.getSelectedItem();

		String posicao = (String) cbxPosicao.getSelectedItem();
		
				
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome(txtNome.getText());
		pessoa.setTelefone(txtTelefone.getText());
		pessoa.setFuncao(txtFuncao.getText());
				
		if (instituto != null &&
				pessoa.getNome()     != null &&
				pessoa.getTelefone() != null &&
				pessoa.getFuncao()   != null &&
				!pessoa.getNome().isEmpty()  &&
				!pessoa.getTelefone().isEmpty() &&
				!pessoa.getFuncao().isEmpty()) {			
			
			if(saida == null || saida == "") {
				saida = "c:\\temp";
			}
					
			if(instituto =="CSC") {
				pessoa.setInstituto(Instituto.CSC);
			} 
	        if (instituto == "TEATRO"){
			    pessoa.setInstituto(Instituto.TEATRO);		    
			}
	
	        if (instituto == "IPG"){
			    pessoa.setInstituto(Instituto.IPG);		    
			}
	
	        if (instituto == "HUCM"){
			    pessoa.setInstituto(Instituto.HUCM);		    
			}
	
	        if (instituto == "AMBULATORIO"){
			    pessoa.setInstituto(Instituto.AMBULATORIO);		    
			}		
								
			assinatura.criarAssinatura(pessoa, saida, posicao);
		} else {
			JOptionPane.showMessageDialog(null, "Voce precisa preencher todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	protected void btnLimparClick(ActionEvent evt) {
		txtNome.setText("");
		txtFuncao.setText("");
		txtTelefone.setText("");
		
	}

	@Override
	protected void btnFecharClick(ActionEvent evt) {
		this.setVisible(false);
		this.dispose();
		
	}

	@Override
	protected void btnPastaClick(ActionEvent evt) {
		
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showDialog(Gerador.this, "Arquivo");
		
		 if (returnVal == JFileChooser.APPROVE_OPTION) {
         	saida = fc.getSelectedFile().getAbsolutePath(); 
         	lblPasta.setText(saida);

         } else if (returnVal == JFileChooser.CANCEL_OPTION) {
             return;

         } else if (returnVal == JFileChooser.UNDEFINED_CONDITION) {
             return;
         }
		 
		 
	}

}
