package graphicComponents;

import java.awt.Graphics;

public class Rectangle extends Point {
	private int height;
	private int width;
	private int dx, dy;
	private boolean isSelected;
	
	public Rectangle(int x, int y, int height, int width) {
		super(x, y);
		this.dx = x;
		this.dy = y;
		this.height = height;
		this.width = width;
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		g.drawRect(dx, dy, width, height);
		if (isSelected) {
			Outline ol = new Outline(new Point(dx-5, dy-5), width+10, height+10);
			ol.drawSpecific(g);
		}
	}
	
	@Override
	public boolean encloses(int x, int y) {
		return x>dx && x<dx+width && y>dy && y<dy+height;
	}
	
	@Override
	public void moveTo(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	protected void setSelectedMode(boolean isSelected) {
		super.setSelectedMode(isSelected);
		this.isSelected = isSelected;
	}
}
