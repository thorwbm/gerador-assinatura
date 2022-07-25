package com.feluma.assinatura.gerador;

import java.awt.Color;
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

import com.feluma.assinatura.model.Pessoa;

public class GeradorAssinatura {


	public void criarAssinatura(Pessoa pessoa, String saida) {		
		try {
			BufferedImage logo = ImageIO.read(new FileInputStream("c:/image/" + pessoa.getInstituto().getLogo() + ".png"));
			int largura = logo.getWidth();
			int altura  = logo.getHeight();		
			
			BufferedImage assinatura = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);
			
			Graphics2D graphic = (Graphics2D) assinatura.getGraphics();
			
			graphic.drawImage(logo, 0, 0, null);
	

					
			Rectangle retangulo = new Rectangle(150, 25, 650,30);		
			Font fonte = new Font(Font.DIALOG_INPUT, Font.BOLD, 30);
			graphic.setColor(Color.YELLOW);
			 centerString(graphic, retangulo, pessoa.getNome(), fonte);		 
	
			retangulo = new Rectangle(150, 55, 650,30);		
			fonte = new Font(Font.DIALOG_INPUT, Font.BOLD, 18);
			graphic.setColor(Color.YELLOW);
			centerString(graphic, retangulo, pessoa.getFuncao(), fonte);		
	
	
			retangulo = new Rectangle(150, 95, 650,30);		
			fonte = new Font(Font.DIALOG_INPUT, Font.BOLD, 24);
			graphic.setColor(Color.YELLOW);
			centerString(graphic, retangulo, pessoa.getTelefone(), fonte);
	
			retangulo = new Rectangle(150, 150, 650,30);		
			fonte = new Font(Font.DIALOG_INPUT, Font.BOLD, 18);
			graphic.setColor(new Color(16776));
			centerString(graphic, retangulo, pessoa.getInstituto().getSite(), fonte);
			
	
			ImageIO.write(assinatura, "png", new File(saida + "\\assinatura-" + pessoa.getInstituto().name() + "-" + primeiroNome(pessoa.getNome()) + ".png"));
			
			JOptionPane.showMessageDialog(null, "Assinatura gerada com sucesso na pasta [" + saida + "] .");

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Arquivo corrompido ou inexistente.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * This method centers a <code>String</code> in 
	 * a bounding <code>Rectangle</code>.
	 * @param g - The <code>Graphics</code> instance.
	 * @param r - The bounding <code>Rectangle</code>.
	 * @param s - The <code>String</code> to center in the
	 * bounding rectangle.
	 * @param font - The display font of the <code>String</code>
	 * 
	 * @see java.awt.Graphics
	 * @see java.awt.Rectangle
	 * @see java.lang.String
	 */
	public void centerString(Graphics2D g, Rectangle r, String s, 
	        Font font) {
	    FontRenderContext frc = 
	            new FontRenderContext(null, true, true);

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

}
