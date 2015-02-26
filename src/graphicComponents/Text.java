package graphicComponents;

import java.awt.Graphics;

public class Text extends Point {
	private int height;
	private int width;
	private int dx, dy;
	private String text = "";
	private final int FONTWIDTH = 7;
	private final int FONTHEIGHT = 15;
	
	public Text(int x, int y, String text) {
		super(x, y);
		setText(text);
		dx = x;
		dy = y;
	}
	
	@Override
	protected void drawSpecific(Graphics g) {
		g.drawString(text, dx, dy);
	}
	
	@Override
	public boolean encloses(int x, int y) {
		return x>dx && x<dx+width && y+height>dy && y<dy;
	}
	
	@Override
	public void moveTo(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setText(String text) {
		this.text = text;
		calculateSize();
	}
	
	private void calculateSize() {
		this.height = FONTHEIGHT; // Styras av fontstorleken!!!
		this.width = FONTWIDTH*text.length(); // Styras av fontstorleken!!!
	}
}
