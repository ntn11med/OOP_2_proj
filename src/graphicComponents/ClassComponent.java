package graphicComponents;

import java.awt.Graphics;

public class ClassComponent extends Point {
	private int headHeight;
	private int attributeHeight;
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
		this.attributeHeight = height;
		this.methodHeight = height;
		this.width = width;
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		g.drawRect(dx, dy, width, headHeight);
		g.drawRect(dx, dy+headHeight, width, attributeHeight);
		g.drawRect(dx, dy+headHeight+attributeHeight, width, methodHeight);
		if (isSelected) {
			Outline ol = new Outline(new Point(dx-5, dy-5), width+10, headHeight+attributeHeight+methodHeight+10);
			ol.drawSpecific(g);
		}
	}
	
	@Override
	public boolean encloses(int x, int y) {
		return x>dx && x<dx+width && y>dy && y<dy+headHeight+attributeHeight+methodHeight;
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
