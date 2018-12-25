package Custom;

import javax.swing.JPanel;

public class Panel extends JPanel {
    public static final long serialVersionUID = 1L;
    
    public void refresh() {
    	setVisible(false);
    	setVisible(true);
    }
}