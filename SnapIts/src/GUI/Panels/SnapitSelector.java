package GUI.Panels;

import javax.swing.JPanel;

import GUI.GUI;
import SnapItModules.SnapItCommand;

public class SnapitSelector extends JPanel {

	private static final long serialVersionUID = 1L;

	public SnapitSelector() {
		setLayout(null);
		setBackground(GUI.darkerGreyBackground);
		setBounds(0, 0, 350, GUI.fullScreenHeight);
		
		SnapItCommand test = new SnapItCommand();
		test.setText("TEST");
		test.setBounds(10,50,100,100);
		add(test);
	}
	
}
