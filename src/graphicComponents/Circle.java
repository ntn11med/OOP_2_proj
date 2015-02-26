package graphicComponents;

import java.awt.Graphics;

public class Circle extends Point {
	private int radius;
	private boolean isSelected;
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
		if (isSelected) {
			Outline ol = new Outline(new Point(super.x-radius-5, super.y-radius-5), 2*radius+10, 2*radius+10);
			ol.drawSpecific(g);
		}
	}

	@Override
	public boolean encloses(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		return dx * dx + dy * dy <= radius*radius;
	}

	@Override
	protected void setSelectedMode(boolean isSelected) {
		super.setSelectedMode(isSelected);
		this.isSelected = isSelected;
	}
}
