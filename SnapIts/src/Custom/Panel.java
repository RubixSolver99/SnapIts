package Custom;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {
    public static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawRect(400, 200, 300, 300);
		super.paintComponent(g);
	}
	
    public void refresh() {
    	setVisible(false);
    	setVisible(true);
    }
}