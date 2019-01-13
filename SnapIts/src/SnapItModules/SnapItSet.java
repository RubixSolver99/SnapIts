package SnapItModules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class SnapItSet extends ArrayList<SnapItCommand> {

	private static final long serialVersionUID = 1L;
	
	public Timer timer;
	
	public SnapItSet() {
		timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				move();
			}
		});
		timer.setRepeats(true);
		timer.setDelay(1);
		timer.start();
	}
	
	public void move() {
		for (int i = 0; i < size(); i++) {
			if (i == 0) {
				continue;
			}
			
			int offset = 0;
			for (int j = 0; j < i; j++) {
				offset += get(j).getHeight() - (2 * get(j).cornerRadius);
			}
			get(i).setLocation(getFirst().getX(), getFirst().getY() + offset);
		}
	}
	
	public SnapItCommand getFirst() {
		return get(0);
	}
	
	public SnapItCommand getLast() {
		return get(size() - 1);
	}
	
}