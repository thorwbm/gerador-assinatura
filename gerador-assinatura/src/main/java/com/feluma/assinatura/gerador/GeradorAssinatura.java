package com.feluma.assinatura.gerador;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.feluma.assinatura.model.Cor;
import com.feluma.assinatura.model.Pessoa;

public class GeradorAssinatura {


	public void criarAssinatura(Pessoa pessoa, String saida, String posicao)  {		
		try {
			BufferedImage logo = ImageIO.read(new FileInputStream("c:/image/" + pessoa.getInstituto().getLogo() + ".png"));
			int largura = logo.getWidth();
			int altura  = logo.getHeight();		
			
			BufferedImage assinatura = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);
			
			Graphics2D graphic = (Graphics2D) assinatura.getGraphics();
			
			graphic.drawImage(logo, 0, 0, null);
			
			
			
			
			//Font fonte = new Font(Font.DIALOG_INPUT, Font.BOLD, 30);
			Font fonte = new Font("Arial", Font.BOLD,30);
			graphic.setColor(Cor.AZUL.getCor());
			posicionaString(graphic, pessoa.getNome(), fonte, 150, 25, 650,30, posicao);
		
			fonte = new Font("Arial", Font.BOLD, 18);
			graphic.setColor(Cor.LARANJA.getCor());
			posicionaString(graphic, pessoa.getFuncao(), fonte, 150, 55, 650,30, posicao);
			
			fonte = new Font("Arial", Font.BOLD, 24);
			graphic.setColor(Cor.PRETO.getCor());
			posicionaString(graphic,  pessoa.getTelefone(), fonte, 150, 95, 650,30, posicao);
		
			fonte = new Font("Arial", Font.BOLD, 18);
			graphic.setColor(Cor.PRETO.getCor());
			posicionaString(graphic, pessoa.getInstituto().getSite(), fonte, 150, 150, 650,30, posicao);
			
			ImageIO.write(assinatura, "png", new File(saida + "\\assinatura-" + pessoa.getInstituto().name() + "-" + primeiroNome(pessoa.getNome()) + ".png"));
			
			JOptionPane.showMessageDialog(null, "Assinatura gerada com sucesso na pasta [" + saida + "] .");
	
		}  catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo corrompido ou inexistente.", "Erro", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void centerString(Graphics2D g, Rectangle r, String s, 
	        Font font) {
	    FontRenderContext frc = new FontRenderContext(null, true, true);

	    Rectangle2D r2D = font.getStringBounds(s, frc);
	    int rWidth = (int) Math.round(r2D.getWidth());
	    int rHeight = (int) Math.round(r2D.getHeight());
	    int rX = (int) Math.round(r2D.getX());
	    int rY = (int) Math.round(r2D.getY());

	    int a = (r.width / 2) - (rWidth / 2) - rX;
	    int b = (r.height / 2) - (rHeight / 2) - rY;

	    g.setFont(font);
	    g.drawString(s, r.x + a, r.y + b);  
	}
	
	public String primeiroNome(String nome) {
      String linha = nome;
      String pattern = "\\S+";
      String retorno = "";

      Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(linha);
      if (m.find( )) {
        retorno = m.group(0) ;     
      }
     return retorno; 
	}
	
	public void posicionaString(Graphics2D g, String s,  Font font, int x, int y, int largura, int altura, String posicao) {
		
	    FontRenderContext frc =  new FontRenderContext(null, true, true);
	    Rectangle r = new Rectangle(x, y, largura, altura);
	    	    
	    Rectangle2D r2D = font.getStringBounds(s, frc);
	    int rWidth = (int) Math.round(r2D.getWidth());
	    int rHeight = (int) Math.round(r2D.getHeight());
	    int rX = (int) Math.round(r2D.getX());
	    int rY = (int) Math.round(r2D.getY());
	    
	    int a = (r.width);
		int b = (r.height / 2) - (rHeight / 2) - rY; 

	    if(posicao == "center") {
		     a = (r.width / 2) - (rWidth / 2) - rX;
		     b = (r.height / 2) - (rHeight / 2) - rY;
	    } else if (posicao == "left"){
	    	 a = (5);
			 b = (r.height / 2) - (rHeight / 2) - rY; 
	    } else if (posicao == "right"){
	    	 a = (r.width) - rWidth - 10;
			 b = (r.height / 2) - (rHeight / 2) - rY; 
	    }

	    g.setFont(font);
	    g.drawString(s, r.x + a, r.y + b);  
	}
	

}
