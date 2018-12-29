package GUI.Panels;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Custom.Panel;
import GUI.GUI;
import SnapItModules.Adders.SnapItCommandAdder;

public class Project extends Panel {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane selectorScrollPane;
	
	public class SelectorPanel extends Panel {
		private static final long serialVersionUID = 1L;
		
		public SelectorPanel() {
			setLayout(null);
			setPreferredSize(new Dimension(350, GUI.fullScreenHeight+1000));
			setBackground(GUI.darkerGreyBackground);

			SnapItCommandAdder test = new SnapItCommandAdder("TEST");
			test.setBounds(50, 50, 100, 100);
			add(test);
			
		}
	}
	
	public class BuilderPanel extends Panel {
		private static final long serialVersionUID = 1L;
		
		public BuilderPanel() {
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

	public Project() {
		setLayout(null);
		setBounds(0, 0, GUI.fullScreenWidth, GUI.fullScreenHeight);
		setBackground(null);
		
		selectorScrollPane = new JScrollPane(new SelectorPanel());
		selectorScrollPane.setBounds(0,30,350,GUI.fullScreenHeight - 30);
		selectorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		selectorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		selectorScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		add(selectorScrollPane);
		add(new BuilderPanel());
	}
	
	
}
