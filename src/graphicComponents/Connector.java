package graphicComponents;

import java.awt.Graphics;

public class Connector extends Point {
	private int height;
	private int width;
	private int dx, dy;
	private boolean isSelected;
	
	public Connector(int x, int y, int height, int width) {
		super(x, y);
		this.dx = x;
		this.dy = y;
		this.height = height;
		this.width = width;
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		g.drawLine(dx, dx+width, dy, dy+height);
		if (isSelected) {
			Outline ol = new Outline(new Point(dx-5, dy-5), width+10, height+10);
			ol.drawSpecific(g);
		}
	}
	
	@Override
	public boolean encloses(int x, int y) {
		return x>dx-3 && x<dx+width+3 && y>dy-3 && y<dy+height+3;
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
