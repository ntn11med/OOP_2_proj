package graphicComponents;

import java.awt.Graphics;
import model.ClassData;

public class ClassComponent extends Point {
	private int headHeight;
	private int attributeHeight;
	private int methodHeight;
	private int width;
	protected int dx, dy;
	private boolean isSelected;
	private ClassData cd = new ClassData("Class");
	private final int HEAD_HEIGHT = 40;
	private final int FONT_HEIGHT = 8;
	private final int FONT_WIDTH = 10;
	
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
		calcuateBorders(data);
	}
	
	private void calcuateBorders(ClassData data) {
		this.headHeight = HEAD_HEIGHT;
		if (data.getAttributes().size()>0)
			this.attributeHeight = data.getAttributes().size() * (15 + FONT_HEIGHT);
		if (data.getMethods().size()>0)
			this.methodHeight = data.getMethods().size() * (15 + FONT_HEIGHT);
		this.width = data.getMaxLineLenght() * FONT_WIDTH;
		cd = data;
	}
	
	public void updateData(ClassData data) {
		calcuateBorders(data);
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		if (cd.getRole().toString().equals("<< Interface >>")) {
			g.drawString("<< interface >>", dx + 5, dy + 5 + FONT_HEIGHT);
		} else {
			g.drawString("", dx + 5, dy + 5 + FONT_HEIGHT);
		}
		g.drawString(cd.getName(), dx + 5, dy + 15 + 2 * FONT_HEIGHT);
		for (int i = 0; i < cd.getAttributes().size(); i++)
			g.drawString(cd.getAttributes().get(i), dx + 5, dy + HEAD_HEIGHT + 2 * FONT_HEIGHT * (i + 1) );
		for (int i = 0; i < cd.getMethods().size(); i++)
			g.drawString(cd.getMethods().get(i), dx + 5, dy + HEAD_HEIGHT + attributeHeight + 2 * FONT_HEIGHT * (i + 1) );
		g.drawRect(dx, dy, width, headHeight);
		g.drawRect(dx, dy+headHeight, width, attributeHeight);
		g.drawRect(dx, dy+headHeight+attributeHeight, width, methodHeight);
		if (isSelected) {
			Outline ol = new Outline(new Point(dx-5, dy-5), width+10, headHeight+attributeHeight+methodHeight+10);
			ol.drawSpecific(g);
		}
		for (int i = 0; i < cd.getAssociationKeys().size(); i++) {
			if (cd.getAssociationKeys().get(i) != null) {
				LineCoordinateTO coordinates = ConnectorLineCalculator.calulateCoordinates(dx, dy, cd.getAssociationKeys().get(i));
				g.drawLine(coordinates.getX1(), coordinates.getY1(), coordinates.getX2(), coordinates.getY2());
			}
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
