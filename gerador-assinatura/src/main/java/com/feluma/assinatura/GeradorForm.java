package com.feluma.assinatura;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public  abstract class GeradorForm extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static final Integer TAMANHO_TXT = 50;

	protected JLabel lblNome;
	protected JTextField txtNome;
	
	protected JLabel lblFuncao;
	protected JTextField txtFuncao;
	
	protected JLabel lblTelefone;
	protected JTextField txtTelefone;
	
	protected JLabel lblInstituto;
	protected JComboBox<String> cbxInstituto;
	
	protected JLabel lblPasta;
	protected JButton btnPasta;
	
	protected JPanel pnlForm;
	protected JPanel pnlRodape;
	
	protected JButton btnGerar;
	protected JButton btnLimpar;
	protected JButton btnFechar;
	
	public GeradorForm() {
		this.inicializar();
		this.eventos();
	}
	
	private void inicializar() {
		this.setTitle("Gerador de assinaturas");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);		
		this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
		
		this.setResizable(false);
		
		this.pack();
		
	}

	public JPanel getPnlForm() {
		if(pnlForm == null) {
			pnlForm = new JPanel(new GridLayout(5,2));

			String[] comboMensagens = {"CSC","HUCM","IPG","TEATRO","AMBULATORIO"};
			lblNome = new JLabel("Nome");
			txtNome = new JTextField(TAMANHO_TXT);
			
			lblFuncao = new JLabel("Setor");
			txtFuncao = new JTextField(TAMANHO_TXT);
			
			lblTelefone = new JLabel("Telefone");
			txtTelefone = new JTextField(TAMANHO_TXT);
			txtTelefone.setText("+55 (31) ");
						
			lblInstituto = new JLabel("Instituto");
			cbxInstituto = new JComboBox<String>(comboMensagens);
			
			lblPasta = new JLabel("Selecione uma pasta de destino.");
			btnPasta = new JButton("Arquivo Destino");
			btnPasta.setBounds(50, 50, 100, 50);

			pnlForm.add(lblNome);
			pnlForm.add(txtNome);
			
			pnlForm.add(lblFuncao);
			pnlForm.add(txtFuncao);
			
			pnlForm.add(lblTelefone);
			pnlForm.add(txtTelefone);

			pnlForm.add(lblInstituto);
			pnlForm.add(cbxInstituto);
			
			pnlForm.add(btnPasta);
			pnlForm.add(lblPasta);
			
		}
		return pnlForm;
	}

	public JPanel getPnlRodape() {
		if(pnlRodape == null) {
			pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

			btnGerar = new JButton("Gerar");
			btnFechar = new JButton("Fechar");
			btnLimpar = new JButton("Limpar");

			pnlRodape.add(btnGerar);
			pnlRodape.add(btnLimpar);
			pnlRodape.add(btnFechar);
		}
		return pnlRodape;
	}

	protected abstract void btnGerarClick(ActionEvent evt);
	protected abstract void btnLimparClick(ActionEvent evt);
	protected abstract void btnFecharClick(ActionEvent evt);
	protected abstract void btnPastaClick(ActionEvent evt);
	
	private void eventos() {
		btnGerar.addActionListener(this::btnGerarClick);
		btnLimpar.addActionListener(this::btnLimparClick);
		btnFechar.addActionListener(this::btnFecharClick);
		btnPasta.addActionListener(this::btnPastaClick);
	}
}
