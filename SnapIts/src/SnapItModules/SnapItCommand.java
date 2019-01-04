package SnapItModules;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.Timer;

import GUI.GUI;

public class SnapItCommand extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;

	public Color normalColor = null;

	private int mouseX, mouseY;
	private int offsetX, offsetY;
	
	public boolean bottomOn = false;
	public boolean topOn = false;
	
	volatile private boolean mouseDown = false;
	volatile private boolean mouseIn = false;
	volatile private boolean isAttached = false;
	volatile private boolean isRunning = false;

	public SnapItCommand(String name) {
		Color backgroundColor = new Color(0, 135, 234);
		setFocusable(false);
		setForeground(GUI.colorTextDefault);
		setFont(GUI.fontSmaller);
		setText(name);
		
		normalColor = backgroundColor;
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
		
		if (bottomOn) {
			//TYLER UI MAGIC
			g2d.setColor(Color.RED);
			g2d.fillRect(0, getHeight() - 20, 100, 20);
		}
		
		if (topOn) {
			//TYLER UI MAGIC
			g2d.setColor(Color.RED);
			g2d.fillRect(0, 0, 100, 20);
		}

		super.paintComponent(g);
	}
	
	public void setBottomOn(boolean b) {
		bottomOn = b;
		repaint();
	}
	
	public void setTopOn(boolean b) {
		topOn = b;
		repaint();
	}
	
	public void setAttached(boolean b) {
		isAttached = b;
	}
	
	public void setDragging(boolean b) {
		if (b) {
			mouseIn = true;
			mouseDown = true;
			mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
			mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
			offsetX = mouseX - getX();
			offsetY = mouseY - getY();
			initThread();
		}
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
			offsetX = mouseX - getX();
			offsetY = mouseY - getY();
			initThread();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseDown = false;
			if (topOn) {
				GUI.panelProject.manager.snap();
			}
		}
	}

	private synchronized boolean checkAndMark() {
		if (isRunning)
			return false;
		isRunning = true;
		return true;
	}

	private void initThread() {
		if (mouseIn) {
			if (checkAndMark()) {
				new Thread() {
					public void run() {
						Timer timer = new Timer(10, new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (mouseDown) {
									mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
									mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

									int tempX = mouseX - offsetX;
									int tempY = mouseY - offsetY;

									boolean moveX;
									boolean moveY;

									if (tempX >= 1 && tempX + getWidth() <= GUI.fullScreenWidth + 1) {
										moveX = true;
									} else {
										moveX = false;
									}
									if (tempY >= 36 && tempY + getHeight() <= GUI.fullScreenWidth + 1) {
										moveY = true;
									} else {
										moveY = false;
									}

									if (moveX && moveY) {
										setLocation(tempX, tempY);
									} else if (!moveX && moveY) {
										setLocation(getX(), tempY);
									} else if (moveX && !moveY) {
										setLocation(tempX, getY());
									} else {
										setLocation(getX(), getY());
									}
									repaint();
								}
							}
						});
						timer.setInitialDelay(0);
						timer.start();
						isRunning = false;
					}
				}.start();
			}
		}
	}
}