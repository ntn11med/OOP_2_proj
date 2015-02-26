package graphicComponents;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure implements Drawable {
	private Color color;
	private boolean isSelected;
	
	public Figure() {
		this(Color.BLACK);
	}
	
	public Figure(Color c) {
		this.color = c;
		this.isSelected = false;
	}
	
	@Override
	public final void draw(Graphics g) {
		Color currentColor = g.getColor();
		if (color!=null)
			g.setColor(color);
		setSelectedMode(isSelected);
		drawSpecific(g); //call to template method
		g.setColor(currentColor);
	}

	// Template method pattern
	protected abstract void drawSpecific(Graphics g);
	protected abstract void setSelectedMode(boolean isSelected);
	
	public abstract void move(int dx, int dy);
	public abstract void moveTo(int dx, int dy);
	public abstract boolean encloses(int x, int y);

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
}
