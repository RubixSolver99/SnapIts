package SnapItModules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Manager {

	public int snapDistX = 100;
	public int snapDistY = 100;

	public ArrayList<SnapItSet> sets = new ArrayList<SnapItSet>();

	public Timer timer;
	
	public SnapItCommand snap1;
	public SnapItCommand snap2;
	
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
		ArrayList<SnapItCommand> checkTop = new ArrayList<SnapItCommand>();
		ArrayList<SnapItCommand> checkBottom = new ArrayList<SnapItCommand>();
		
		for (int i = 0; i < sets.size(); i++) {
			checkTop.add(sets.get(i).getFirst());
			checkBottom.add(sets.get(i).getLast());
		}
		
		for (int i = 0; i < checkTop.size(); i++) {
			for (int j = 0; j < checkBottom.size(); j++) {
				if (checkTop.get(i).equals(checkBottom.get(j))) {
					continue;
				}
				
				ArrayList<Integer> dists = calcDist(checkTop.get(i), checkBottom.get(j));
				if (dists.get(0) >= -100 && dists.get(0) <= 100 && dists.get(1) >= -100 && dists.get(1) <= 100) {
					if (checkTop.get(i).getY() > checkBottom.get(j).getY()) {
						checkTop.get(i).setTopOn(true);
						checkTop.get(i).setBottomOn(false);
						checkBottom.get(j).setTopOn(false);
						checkBottom.get(j).setBottomOn(true);
						snap1 = checkBottom.get(j);
						snap2 = checkTop.get(i);
					} else {
						checkTop.get(i).setTopOn(false);
						checkTop.get(i).setBottomOn(false);
						checkBottom.get(j).setTopOn(false);
						checkBottom.get(j).setBottomOn(false);
						snap1 = null;
						snap2 = null;
					}
				} else {
					checkTop.get(i).setTopOn(false);
					checkTop.get(i).setBottomOn(false);
					checkBottom.get(j).setTopOn(false);
					checkBottom.get(j).setBottomOn(false);
					snap1 = null;
					snap2 = null;
				}
			}
		}

	}
	
	public void snap() {
		snap2.setLocation(snap1.getX(), snap1.getY() + snap1.getHeight() - (snap1.cornerRadius * 2));
		snap1.setBottomOn(false);
		snap2.setTopOn(false);
		sets.get(snap1.getIndex()).add(snap2);
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
}
