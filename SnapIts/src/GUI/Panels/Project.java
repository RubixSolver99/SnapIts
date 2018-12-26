package GUI.Panels;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLabel;

import Custom.Panel;
import GUI.GUI;
import SnapItModules.SnapItCommand;

public class Project extends Panel {
	
	private static final long serialVersionUID = 1L;
	
	public class SelectorPanel extends Panel {
		private static final long serialVersionUID = 1L;
		
		public SelectorPanel() {
			setLayout(null);
			setBounds(0, 0, 350, GUI.fullScreenHeight);
			setBackground(GUI.darkerGreyBackground);
		}
	}
	
	public class BuilderPanel extends Panel {
		private static final long serialVersionUID = 1L;
		
		public BuilderPanel() {
			setLayout(null);
			setBounds(0, 0, GUI.fullScreenWidth, GUI.fullScreenHeight);
			setBackground(GUI.darkGreyBackground);
		}
	}

	public Project() {
		setLayout(null);
		setBounds(0, 0, GUI.fullScreenWidth, GUI.fullScreenHeight);
		setBackground(null);
		
		SnapItCommand test = new SnapItCommand();
		test.setText("TEST");
		test.setBounds(50, 50, 100, 100);
		add(test);
		
		JLabel labelTest = new JLabel();
		labelTest.setBounds(400, 100, 400, 50);
		labelTest.setText("Main Project Panel");
		labelTest.setForeground(GUI.colorTextDefault);
		labelTest.setFont(GUI.fontDefault);
		add(labelTest);
		
		add(new SelectorPanel());
		add(new BuilderPanel());
	}
	
	
}
