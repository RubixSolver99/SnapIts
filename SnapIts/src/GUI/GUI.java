package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFileChooser;

import Main.*;
import Custom.MainMenuBar;
import Custom.Panel;
import GUI.Panels.NewProject;
import GUI.Panels.StartUp;

public class GUI {
	//GUI GLOBAL VARIABLES, CHANGES EVERYWHERE

	public static Color colorTheme1 = new Color(0, 0, 255);
	public static Color colorTheme2 = new Color(20, 200, 0);
	public static Color colorTextDefault = new Color(255, 255, 255);

	public static Dimension dimensionFullScreen = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static Font fontDefault = new Font("Lucida Console", Font.PLAIN, 20);

	public static int fullScreenHeight = dimensionFullScreen.height;
	public static int fullScreenWidth = dimensionFullScreen.width;

	//END GUI GLOBAL VARIABLES

	static Panel currentPanel;

	public static MainMenuBar mainMenuBar;
	public static Panel panelStartUp, panelNewProject;

	public GUI() {
		init();
	}

	public static void init() {
		panelStartUp = new StartUp();
		panelNewProject = new NewProject();

		currentPanel = panelStartUp;

		mainMenuBar = new MainMenuBar();
		Main.MainFrame.add(mainMenuBar);

		changePanel(currentPanel);
	}
	
	public static void changePanel(Panel newPanel) {
		Main.MainFrame.remove(currentPanel);
		currentPanel = newPanel;
		Main.MainFrame.add(currentPanel);
		Main.MainFrame.setVisible(false);
		Main.MainFrame.setVisible(true);
	}
}