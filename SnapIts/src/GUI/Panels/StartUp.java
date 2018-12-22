package GUI.Panels;

import javax.swing.JLabel;

import Custom.Panel;
import GUI.GUI;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StartUp extends Panel {
	public static final long serialVersionUID = 1L;
	private BufferedImage backgroundImage;
	private BufferedImage logoImage;
	private BufferedImage newImage;
    public StartUp() {
		setLayout(null);
		setBackground(GUI.darkGreyBackground);
		
		try {                
	          backgroundImage = ImageIO.read(new File("Assets\\LogoBackground.jpg"));
	          logoImage = ImageIO.read(new File("Assets\\LogoTrans.png"));
	          newImage = ImageIO.read(new File("Assets\\NewProject.png"));
	       } catch (IOException ex) {
	            // handle exception...
	       }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(backgroundImage, 0, 0, GUI.fullScreenWidth, GUI.fullScreenHeight, this);
	        g.drawImage(logoImage, 30, 10, 600, 300, this);
	        g.drawImage(newImage, 150, 265, 250, 250, this);
		
	}
}