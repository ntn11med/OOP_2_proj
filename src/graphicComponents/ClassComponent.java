package graphicComponents;

import java.awt.Graphics;

public class ClassComponent extends Point {
	private int headHeight;
	private int attrubeHeight;
	private int methodHeight;
	private int width;
	private int dx, dy;
	private boolean isSelected;
	
	public ClassComponent(int x, int y) {
		this(x, y, 30, 60);
	}
	
	public ClassComponent(int x, int y, int height, int width) {
		super(x, y);
		this.dx = x;
		this.dy = y;
		this.headHeight = height;
		this.attrubeHeight = height;
		this.methodHeight = height;
		this.width = width;
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		g.drawRect(dx, dy, width, headHeight);
		g.drawRect(dx, dy+headHeight, width, attrubeHeight);
		g.drawRect(dx, dy+headHeight+attrubeHeight, width, methodHeight);
		if (isSelected) {
			Outline ol = new Outline(new Point(dx-5, dy-5), width+10, headHeight+attrubeHeight+methodHeight+10);
			ol.drawSpecific(g);
		}
	}
	
	@Override
	public boolean encloses(int x, int y) {
		return x>dx && x<dx+width && y>dy && y<dy+headHeight+attrubeHeight+methodHeight;
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
