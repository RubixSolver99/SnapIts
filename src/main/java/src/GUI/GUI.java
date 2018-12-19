package src.GUI;

import javax.swing.JPanel;

public class GUI {
	public static JPanel panelMain;

	public GUI() {
		init();
	}

	public static void init() {
		System.out.println("Hello, GUI!");
		panelMain = new JPanel();
		//Main.MainFrame.add(panelMain);
	}
}