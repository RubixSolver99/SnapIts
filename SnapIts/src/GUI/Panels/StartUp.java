package GUI.Panels;

import javax.swing.JLabel;

import Custom.Panel;
import GUI.GUI;

public class StartUp extends Panel {
	public static final long serialVersionUID = 1L;

    public StartUp() {
		setLayout(null);
		setBackground(GUI.darkGreyBackground);

		JLabel labelTest = new JLabel();
		labelTest.setBounds(100, 100, 200, 50);
		labelTest.setText("START UP");
		labelTest.setForeground(GUI.colorTextDefault);
		labelTest.setFont(GUI.fontDefault);
		add(labelTest);
	}
}