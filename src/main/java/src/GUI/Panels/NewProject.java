package src.GUI.Panels;

import src.Custom.Label;
import src.Custom.Panel;
import src.GUI.GUI;

public class NewProject extends Panel {
	public static final long serialVersionUID = 1L;

    public NewProject() {
		setLayout(null);
		setBackground(GUI.colorTheme2);

		Label labelTest = new Label();
		labelTest.setBounds(100, 100, 200, 50);
		labelTest.setText("NEW PROJECT");
		labelTest.setFont(GUI.fontDefault);
		add(labelTest);
	}
}