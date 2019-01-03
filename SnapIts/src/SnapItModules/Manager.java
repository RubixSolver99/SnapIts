package SnapItModules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Manager {
	
	public int snapDistX = 100;
	public int snapDistY = 100;
	
	public ArrayList<SnapItCommand> modules = new ArrayList<SnapItCommand>();
	
	public SnapItCommand snap1;
	public SnapItCommand snap2;
	
	public Timer timer;
	
	public Manager() {
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkForSnaps();
			}
		});
		timer.setRepeats(true);
		timer.setDelay(10);
		timer.start();
	}
	
	public void checkForSnaps() {
		for (int i = 0; i < modules.size(); i++) {
			for (int j = 0; j < modules.size(); j++) {
				if (i == j) {
					continue;
				}
				
				ArrayList<Integer> dists;
				dists = calcDist(modules.get(i), modules.get(j));
				
				if (dists.get(0) <= snapDistX && dists.get(0) >= -snapDistX) {
					if (dists.get(1) <= snapDistY && dists.get(1) > 0) {
						modules.get(i).setTopOn(true);
						modules.get(j).setBottomOn(true);
						setSnaps(modules.get(i), modules.get(j));
					} else if (dists.get(1) >= -snapDistY && dists.get(1) < 0) {
						modules.get(i).setBottomOn(true);
						modules.get(j).setTopOn(true);
						setSnaps(modules.get(i), modules.get(j));
					} else {
						modules.get(i).setTopOn(false);
						modules.get(i).setBottomOn(false);
						modules.get(j).setTopOn(false);
						modules.get(j).setBottomOn(false);
						setSnaps(null, null);
					}
				} else {
					modules.get(i).setTopOn(false);
					modules.get(i).setBottomOn(false);
					modules.get(j).setTopOn(false);
					modules.get(j).setBottomOn(false);
					setSnaps(null, null);
				}
			}
		}
	}
	
	//return ArrayList of Integers: (distX, distY)
	public ArrayList<Integer> calcDist(SnapItCommand sn1, SnapItCommand sn2) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sn1X = sn1.getX();
		int sn1Y = sn1.getY();
		int sn2X = sn2.getX();
		int sn2Y = sn2.getY();
		
		int distX = sn1X - sn2X;
		int distY = sn1Y - sn2Y;
		list.add(distX);
		list.add(distY);
		return list;
	}
	
	public void setSnaps(SnapItCommand sn1, SnapItCommand sn2) {
		//check for the lesser y value
		snap1 = sn1;
		snap2 = sn2;
	}
}
