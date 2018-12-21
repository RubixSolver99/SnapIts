package Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Framework.Framework;
import GUI.GUI;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static Framework framework;
	public static GUI gui;

    public static JFrame MainFrame;
	public static JPanel panelMain;

    public Main() {
		setTitle("Snap Its");
		setPreferredSize(GUI.dimensionFullScreen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		pack();
	}

	public static void main(String[] Args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame = new Main();
				
				framework = new Framework();
				gui = new GUI();

				MainFrame.setVisible(true);
			}
		});

	}

}
