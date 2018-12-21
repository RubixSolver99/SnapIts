package GUI.Panels;

import Custom.Panel;

public class ProjectMain extends Panel {
	public static final long serialVersionUID = 1L;

    public ProjectMain() {
		Project projectWindow = new Project();
		SnapitSelector selector = new SnapitSelector();
		setLayout(null);
		add(projectWindow);
		add(selector);
	}
}