package GUI.Panels;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Custom.Panel;
import GUI.GUI;
import Main.Main;
import SnapItModules.Manager;
import SnapItModules.SnapItCommand;
import SnapItModules.SnapItSet;
import SnapItModules.Adders.SnapItCommandAdder;

public class Project extends Panel {
	
	private static final long serialVersionUID = 1L;
	
	private JScrollPane selectorScrollPane;
	private JScrollPane builderScrollPane;
	
	public Manager manager;
	
	public class SelectorPanel extends Panel {
		private static final long serialVersionUID = 1L;
		
		public SelectorPanel() {
			setLayout(null);
			setPreferredSize(new Dimension(350, GUI.fullScreenHeight+1000));
			setBackground(GUI.darkerGreyBackground);
			removeAll();

			SnapItCommandAdder test = new SnapItCommandAdder("TEST", "print(\"test\")");
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
			removeAll();
			
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
		
		reset();
	}
	
	public void reset() {
		removeAll();
		Main.framework.reset();
		
		manager = new Manager();
		
		selectorScrollPane = new JScrollPane(new SelectorPanel());
		selectorScrollPane.setBounds(0,30,350,GUI.fullScreenHeight - 30);
		selectorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		selectorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		selectorScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		builderScrollPane = new JScrollPane(new BuilderPanel());
		builderScrollPane.setBounds(0,30,GUI.fullScreenWidth, GUI.fullScreenHeight - 30);
		builderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		builderScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		builderScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		
		add(selectorScrollPane);
		add(builderScrollPane);
		
	}
	
	public String save() {
		String string = "";
		
		string += "!#PROJECT#!\n";
		
		for (int i = 0; i < manager.sets.size(); i++) {
			string += "SnapItSet{\n";
			for (int j = 0; j < manager.sets.get(i).size(); j++) {
				SnapItCommand snapTemp = manager.sets.get(i).get(j);
				string += "SnapItCommand[" + snapTemp.getX() + ", " + snapTemp.getY() + ", " + snapTemp.getWidth() + ", " + snapTemp.getHeight() + ", " + snapTemp.getName() + ", " + snapTemp.getPyCode() + "]\n";
			}
			string += "}SnapItSet\n";
		}
		
		string += "!#END_PROJECT#!\n";
		
		return string;
	}
	
	public void load (String string) {
		reset();
		ArrayList<String> projectStringList = Main.framework.fileIO.lineParser(string);
		int arrayIndex = 0;
		int arrayIndex2 = 0;
		for (int i = 0; i < projectStringList.size(); i++) {
			String stringTemp = projectStringList.get(i);
			if (stringTemp.startsWith("SnapItSet{")) {
				GUI.panelProject.manager.sets.add(new SnapItSet());
				arrayIndex2 = 0;
			} else if (stringTemp.startsWith("SnapItCommand[")) {
				String x, y, width, height, name, code;
				x = stringTemp.substring(14, stringTemp.indexOf(", "));
				stringTemp = stringTemp.substring(stringTemp.indexOf(", ") + 2);
				y = stringTemp.substring(0, stringTemp.indexOf(", "));
				stringTemp = stringTemp.substring(stringTemp.indexOf(", ") + 2);
				width = stringTemp.substring(0, stringTemp.indexOf(", "));
				stringTemp = stringTemp.substring(stringTemp.indexOf(", ") + 2);
				height = stringTemp.substring(0, stringTemp.indexOf(", "));
				stringTemp = stringTemp.substring(stringTemp.indexOf(", ") + 2);
				name = stringTemp.substring(0, stringTemp.indexOf(", "));
				stringTemp = stringTemp.substring(stringTemp.indexOf(", ") + 2);
				code = stringTemp.substring(0, stringTemp.indexOf("]"));
				stringTemp = stringTemp.substring(stringTemp.indexOf("]") + 1);
				SnapItCommand temp = new SnapItCommand(name, code, arrayIndex);
				temp.setBounds(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(width), Integer.parseInt(height));

				int size = GUI.panelProject.manager.sets.size();
				GUI.panelProject.manager.sets.get(size - 1).add(temp);
				GUI.panelProject.add(GUI.panelProject.manager.sets.get(size - 1).get(arrayIndex2));
				GUI.panelProject.setComponentZOrder(GUI.panelProject.manager.sets.get(size - 1).get(arrayIndex2), 0);
				arrayIndex2++;
			} else if (stringTemp.startsWith("}SnapItSet")) {
				arrayIndex++;
			}
		}
	}
	
	public void close() {
		manager.timer.stop();
	}
}
