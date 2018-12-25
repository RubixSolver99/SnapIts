package Custom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

import GUI.GUI;
import Main.Main;

public class MainMenuBar extends JMenuBar {
	public static final long serialVersionUID = 1L;
	public static JMenu menuFile, menuEdit, menuView;
	public static JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs; //menuFile
	public static JMenuItem menuItemUndo, menuItemRedo, menuItemCut, menuItemCopy, menuItemPaste; //menuEdit
	public static JCheckBox menuItemShowSelector;

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
		menuItemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
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
		
		menuItemUndo = new JMenuItem("Undo");
		menuItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		menuItemUndo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Need to implement an action for UNDO!
			}
		});
		menuEdit.add(menuItemUndo);
		
		menuItemRedo = new JMenuItem("Redo");
		menuItemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		menuItemRedo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Need to implement an action for REDO!
			}
		});
		menuEdit.add(menuItemRedo);
		
		menuEdit.addSeparator();
		
		menuItemCut = new JMenuItem(new DefaultEditorKit.CutAction());
		menuItemCut.setText("Cut");
		menuItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		menuEdit.add(menuItemCut);
		
		menuItemCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		menuItemCopy.setText("Copy");
		menuItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menuEdit.add(menuItemCopy);
		
		menuItemPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		menuItemPaste.setText("Paste");
		menuItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		menuEdit.add(menuItemPaste);
		
		add(menuEdit);
		//End Edit Menu
		
	}

}