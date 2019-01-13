package GUI.Panels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import Custom.Panel;
import GUI.GUI;
import Main.Main;

public class StartUp extends Panel {
	public static final long serialVersionUID = 1L;
	private BufferedImage backgroundImage;
	private BufferedImage logoImage;

	public StartUp() {
		setLayout(null);
		setBackground(GUI.darkGreyBackground);
		
		String s = File.separator;
		backgroundImage = Main.framework.fileIO.getImage("Assets" + s + "LogoBackground.jpg");
		logoImage = Main.framework.fileIO.getImage("Assets" + s + "LogoTrans.png");

		if (backgroundImage == null || logoImage == null) {
			// if the images weren't returned......
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, GUI.fullScreenWidth, GUI.fullScreenHeight, this);
		g.drawImage(logoImage, 40, 10, 600, 300, this);

	}
}