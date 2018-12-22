package SnapItModules;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import GUI.GUI;

public class SnapItCommand extends JButton implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;

	public Color normalColor = null;
	public Color lightColor = null;
	public Color darkColor = null;

	public SnapItCommand() {
		Color backgroundColor = new Color(0,135,234);
		setFocusable(false);
		setForeground(GUI.colorTextDefault);
		setFont(GUI.fontSmaller);
		
		this.normalColor = backgroundColor;
		this.lightColor = backgroundColor.brighter();
		this.darkColor = backgroundColor.darker();
		addActionListener(this);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
