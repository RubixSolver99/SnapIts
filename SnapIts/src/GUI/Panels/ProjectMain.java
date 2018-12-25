package GUI.Panels;

import Custom.Panel;

public class ProjectMain extends Panel {
	public static final long serialVersionUID = 1L;
	
	public Project projectWindow;
	public SnapitSelector selector;

    public ProjectMain() {
		projectWindow = new Project();
		selector = new SnapitSelector();
		setLayout(null);
		add(selector);
		add(projectWindow);
	}
}