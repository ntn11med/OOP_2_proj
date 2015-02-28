package graphicComponents;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Outline extends Point {
	private int width;
	private int height;
	private Point point;
	
	public Outline(Point p, int width, int height) {
		this.width = width;
		this.height = height;
		point = p;
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BasicStroke org = (BasicStroke) g2d.getStroke();
		float dash1[] = {5.0f};
		BasicStroke dashed =new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
		g2d.setStroke(dashed);
		g2d.drawRect(point.x, point.y, width, height);
		g2d.setStroke(org);
	}
	
	@Override
	public boolean encloses(int x, int y) {
		return x>point.x && x<point.x+width && y>point.y && y<point.y+height;
	}
	
	@Override
	public void moveTo(int dx, int dy) {
		this.point.x = dx;
		this.point.y = dy;
	}
}
