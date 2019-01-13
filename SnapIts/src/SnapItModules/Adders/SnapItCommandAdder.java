package SnapItModules.Adders;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

import GUI.GUI;
import SnapItModules.SnapItCommand;
import SnapItModules.SnapItSet;

public class SnapItCommandAdder extends JButton implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	public String pyCode;
	
	public Color normalColor = null;
	
	public boolean mouseIsIn = false;
	
	public SnapItCommandAdder(String name, String code) {
		this.name = name;
		pyCode = code;
		Color backgroundColor = new Color(0, 135, 234);
		normalColor = backgroundColor;
		setFocusable(false);
		setForeground(GUI.colorTextDefault);
		setFont(GUI.fontSmaller);
		setText(name);
		addMouseListener(this);
		setContentAreaFilled(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int cornerRadius = 10;

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gp = null;

		gp = new GradientPaint(0, 0, normalColor, 0, getHeight(), normalColor);

		g2d.setPaint(gp);

		// Draws the rounded opaque panel with borders
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For High quality

		Area a = new Area(new Rectangle(0, cornerRadius + 10, getWidth(), getHeight() - (cornerRadius * 2) - 20));
		a.add(new Area(new Rectangle(cornerRadius, 10, getWidth() - (cornerRadius * 2), getHeight() - 20)));
		a.add(new Area(new Ellipse2D.Double(0, 10, cornerRadius * 2, cornerRadius * 2)));
		a.add(new Area(new Ellipse2D.Double(getWidth() - (cornerRadius * 2), 10, cornerRadius * 2, cornerRadius * 2)));
		a.add(new Area(new Ellipse2D.Double(0, getHeight() - (cornerRadius * 2) - 10, cornerRadius * 2, cornerRadius * 2)));
		a.add(new Area(new Ellipse2D.Double(getWidth() - (cornerRadius * 2), getHeight() - (cornerRadius * 2) - 10,
				cornerRadius * 2, cornerRadius * 2)));
		a.add(new Area(new Ellipse2D.Double(25, getHeight() - 20, 20, 20)));
		a.subtract(new Area(new Ellipse2D.Double(25, 0, 20, 20)));
		g2d.fill(a);

		super.paintComponent(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseIsIn = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseIsIn = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (mouseIsIn) {
			spawnSnapItCommand();
		}		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	private void spawnSnapItCommand() {
		SnapItCommand temp = new SnapItCommand(name, pyCode, GUI.panelProject.manager.sets.size());
		temp.setBounds(getX() + 1, getY() + 32, getWidth(), getHeight());
		temp.setDragging(true);
		GUI.panelProject.manager.sets.add(new SnapItSet());
		int size = GUI.panelProject.manager.sets.size();
		GUI.panelProject.manager.sets.get(size - 1).add(temp);
		GUI.panelProject.add(GUI.panelProject.manager.sets.get(size - 1).get(0));
		GUI.panelProject.setComponentZOrder(GUI.panelProject.manager.sets.get(size - 1).get(0), 0);
		GUI.panelProject.refresh();
	}

}
