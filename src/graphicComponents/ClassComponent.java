package graphicComponents;

import java.awt.Graphics;
import model.ClassData;

public class ClassComponent extends Point {
	private int headHeight;
	private int attributeHeight;
	private int methodHeight;
	private int width;
	private int dx, dy;
	private boolean isSelected;
	private ClassData cd;
	private final int HEAD_HEIGHT = 30;
	private final int FONT_HEIGHT = 8;
	private final int FONT_WIDTH = 5;
	
	public ClassComponent(int x, int y) {
		this(x, y, 30, 60);
	}
	
	public ClassComponent(int x, int y, int height, int width) {
		super(x, y);
		this.dx = x;
		this.dy = y;
		this.headHeight = HEAD_HEIGHT;
		this.attributeHeight = height;
		this.methodHeight = height;
		this.width = width;
	}
	
	public ClassComponent(int x, int y, ClassData data) {
		super(x, y);
		this.dx = x;
		this.dy = y;
		this.headHeight = HEAD_HEIGHT;
		this.attributeHeight = data.getAttributes().size() * FONT_HEIGHT;
		this.methodHeight = data.getMethods().size() * FONT_HEIGHT;
		this.width = data.getMaxLineLenght() * FONT_WIDTH;
		cd = data;
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
