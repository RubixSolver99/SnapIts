package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import Custom.MainMenuBar;
import Custom.Panel;
import GUI.Panels.Project;
import GUI.Panels.StartUp;
import Main.Main;

public class GUI {
	//GUI GLOBAL VARIABLES, CHANGES EVERYWHERE

	public static Color darkerGreyBackground = new Color(18, 18, 18);
	public static Color darkGreyBackground = new Color(24,24,24);
	public static Color colorTextDefault = new Color(255, 255, 255);

	public static Dimension dimensionFullScreen = new Dimension( (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 80);
	
	public static Font fontDefault = new Font("Roboto Light", Font.PLAIN, 40);
	public static Font fontSmaller = new Font("Roboto Light", Font.PLAIN, 20);

	public static int fullScreenHeight = dimensionFullScreen.height;
	public static int fullScreenWidth = dimensionFullScreen.width;

	//END GUI GLOBAL VARIABLES

	static Panel currentPanel;
	static FontImporter fontImporter;

	public static MainMenuBar mainMenuBar;
	public static Project panelProject;
	public static StartUp panelStartUp;

	public GUI() {
		init();
	}

	public void init() {
		fontImporter = new FontImporter();
		
		panelStartUp = new StartUp();
		panelProject = new Project();
		
		currentPanel = panelStartUp;

		mainMenuBar = new MainMenuBar();
		Main.MainFrame.add(mainMenuBar);

		changePanel(currentPanel);
	}
	
	public void changePanel(Panel newPanel) {
		Main.MainFrame.remove(currentPanel);
		currentPanel = newPanel;
		Main.MainFrame.add(currentPanel);
		refresh();
	}

	public void refresh() {
		Main.MainFrame.setVisible(false);
		Main.MainFrame.setVisible(true);
		mainMenuBar.refresh();
	}
	

	public void close() {
		
	}
}