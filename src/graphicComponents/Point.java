package graphicComponents;

import java.awt.Graphics;

import model.ClassData;

public class Point extends Figure {
	protected int x, y;
	
	public Point() {
		this(0,0);
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	protected void drawSpecific(Graphics g) {
	}

	@Override
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	@Override
	public boolean encloses(int x, int y) {
		return (this.x == x && this.y == y);
	}

	@Override
	public void moveTo(int dx, int dy) {
		this.x = dx;
		this.y = dy;
	}

	@Override
	protected void setSelectedMode(boolean isSelected) {
	}

	@Override
	public void updateData(ClassData data) {
	}

}
