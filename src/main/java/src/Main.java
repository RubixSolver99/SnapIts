package src;

import src.Framework.*;
import src.GUI.*;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static Framework framework;
	public static GUI gui;

    public static JFrame MainFrame; // not the regular kind
    public static JPanel panelMain;

    public Main() {
		createView(getGraphics());
		setTitle("Snap Its");
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		pack();
	}

	public void createView(Graphics g) {
		panelMain = new JPanel(); //connect a JPanel from GUI to here

		getContentPane().add(panelMain);
	}

	public static void main(String[] Args) {
		framework = new Framework();
		gui = new GUI();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame = new Main();
				MainFrame.setVisible(true);
			}
		});

	}

}
