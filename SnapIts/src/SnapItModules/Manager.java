package SnapItModules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Manager {

	public int snapDistX = 100;
	public int snapDistY = 100;
	

	public ArrayList<ArrayList<SnapItCommand>> modules = new ArrayList<ArrayList<SnapItCommand>>();
	
	public SnapItCommand currentSnap1;
	public SnapItCommand currentSnap2;

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
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < modules.size(); i++) {
			for (int j = 0; j < modules.get(i).size(); j++) {
				if (j == 0) {
					indexes.add(0);
				}
				indexes.set(i, indexes.get(i) + 1);
			}
		}

		for (int i = 0; i < modules.size(); i++) {
			for (int j = 0; j < indexes.get(i); j++) {
				for (int k = 0; k < modules.size(); k++) {
					for (int l = 0; l < indexes.get(i); l++) {
						if (i == k && j == l) {
							continue;
						}

						SnapItCommand testSnap1;
						SnapItCommand testSnap2;

						if (modules.get(i).get(j).getY() < modules.get(k).get(l).getY()) {
							testSnap1 = modules.get(i).get(j);
							testSnap2 = modules.get(k).get(l);
						} else if (modules.get(k).get(l).getY() < modules.get(i).get(j).getY()) {
							testSnap1 = modules.get(k).get(l);
							testSnap2 = modules.get(i).get(j);
						} else {
							testSnap1 = null;
							testSnap2 = null;
						}

						ArrayList<Integer> dists = calcDist(testSnap1, testSnap2);
						if (dists.get(0) != null) {
							
						} else {
							continue;
						}
						
						if (dists.get(0) <= snapDistX && dists.get(0) >= -snapDistX && dists.get(1) <= snapDistY && dists.get(1) >= -snapDistY) {
								modules.get(i).get(j).setBottomOn(true);
								modules.get(k).get(l).setTopOn(true);
								setSnaps(modules.get(i).get(j), modules.get(k).get(l));
						} else {
							modules.get(i).get(j).setTopOn(false);
							modules.get(i).get(j).setBottomOn(false);
							modules.get(k).get(l).setTopOn(false);
							modules.get(k).get(l).setBottomOn(false);
						}
					}
				}
			}
		}
	}

	// return ArrayList of Integers: (distX, distY)
	public ArrayList<Integer> calcDist(SnapItCommand sn1, SnapItCommand sn2) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (sn1 != null) {
			int sn1X = sn1.getX();
			int sn1Y = sn1.getY();
			int sn2X = sn2.getX();
			int sn2Y = sn2.getY();

			int distX = sn2X - sn1X;
			int distY = sn2Y - sn1Y;
			list.add(distX);
			list.add(distY);
		} else {
			list.add(null);
		}
		return list;
	}
	
	public void setSnaps(SnapItCommand sn1, SnapItCommand sn2) {
		currentSnap1 = sn1;
		currentSnap2 = sn2;
	}
	
	public void snap() {
		currentSnap2.setAttached(true);
	}
}
