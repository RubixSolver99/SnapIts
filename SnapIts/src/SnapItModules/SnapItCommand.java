package SnapItModules;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import GUI.GUI;

public class SnapItCommand extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;

	public Color normalColor = null;

	int buttonX, buttonY;
	int mouseX, mouseY;
	int offsetX, offsetY;

	volatile private boolean mouseDown = false;
	volatile private boolean mouseIn = false;
	volatile private boolean isRunning = false;

	public SnapItCommand() {
		Color backgroundColor = new Color(0, 135, 234);
		setFocusable(false);
		setForeground(GUI.colorTextDefault);
		setFont(GUI.fontSmaller);

		normalColor = backgroundColor;
		addMouseListener(this);
		setContentAreaFilled(false);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gp = null;

		gp = new GradientPaint(0, 0, normalColor, 0, getHeight(), normalColor);

		g2d.setPaint(gp);

		// Draws the rounded opaque panel with borders
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For High quality
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);

		super.paintComponent(g);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		mouseIn = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		mouseIn = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	    if (e.getButton() == MouseEvent.BUTTON1) {
	        mouseDown = true;
	        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
	        mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
	        buttonX = getX();
	        buttonY = getY();
	        offsetX = mouseX - buttonX;
	        offsetY = mouseY - buttonY;
	        initThread();
	    }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	    if (e.getButton() == MouseEvent.BUTTON1) {
	        mouseDown = false;
	    }
	}

	private synchronized boolean checkAndMark() {
		if (isRunning)
			return false;
		isRunning = true;
		return true;
	}

	private void initThread() {
		if (checkAndMark()) {
			new Thread() {
				public void run() {
					do {
				        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
				        mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
				        if (mouseX >= 350) {
				        	
				        }
				        setLocation(mouseX - offsetX, mouseY - offsetY);
					} while (mouseDown && mouseIn);
					isRunning = false;
				}
			}.start();
		}
	}
}
