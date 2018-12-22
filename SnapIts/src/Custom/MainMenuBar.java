package Custom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import GUI.GUI;
import Main.Main;

public class MainMenuBar extends JMenuBar {
	public static final long serialVersionUID = 1L;
	public static JMenu menuFile, menuEdit;
	public static JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs;

	public MainMenuBar() {
		setBounds(0, 0, GUI.fullScreenWidth, 30);

		// File Menu
		menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_1);

		menuItemNew = new JMenuItem("New Project");
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItemNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.changePanel(GUI.panelNewProject);
			}
		});
		menuFile.add(menuItemNew);

		menuItemOpen = new JMenuItem("Open Project");
		menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.framework.fileIO.openFile("snapits");
			}
		});
		menuFile.add(menuItemOpen);

		menuItemSave = new JMenuItem("Save Project");
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItemSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.framework.fileIO.saveFile();
			}
		});
		menuFile.add(menuItemSave);
		
		menuItemSaveAs = new JMenuItem("Save Project As");
		menuItemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
		menuItemSaveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuFile.add(menuItemSaveAs);

		add(menuFile);
		// End File Menu
		
		//Edit Menu
		menuEdit = new JMenu("Edit");
		menuEdit.setMnemonic(KeyEvent.VK_2);
		
		
		
		add(menuEdit);
		//End Edit Menu
	}

}