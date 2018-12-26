package GUI.Panels;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JLabel;

import Custom.Panel;
import GUI.GUI;
import SnapItModules.SnapItCommand;

public class Project extends Panel {
	
	private static final long serialVersionUID = 1L;
	
	public class MyGraphics extends JComponent {

        private static final long serialVersionUID = 1L;

        MyGraphics() {
            setBounds(0, 0, GUI.fullScreenWidth, GUI.fullScreenHeight);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillRect(0, 0, 350, GUI.fullScreenHeight);
        }
    }

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
		
		SnapItCommand test = new SnapItCommand();
		test.setText("TEST");
		test.setBounds(50, 50, 100, 100);
		add(test);
		
		add(new MyGraphics());
		
	}
	
	
}
