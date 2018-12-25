package GUI.Panels;

import javax.swing.JLabel;

import Custom.Panel;
import GUI.GUI;

public class Project extends Panel{
	
	private static final long serialVersionUID = 1L;

	public Project() {
		setLayout(null);
		setBounds(0, 0, GUI.fullScreenWidth, GUI.fullScreenHeight);
		setBackground(GUI.darkGreyBackground);

		JLabel labelTest = new JLabel();
		labelTest.setBounds(400, 100, 400, 50);
		labelTest.setText("Main Project Panel");
		labelTest.setForeground(GUI.colorTextDefault);
		labelTest.setFont(GUI.fontDefault);
		add(labelTest);
	}
	
}
