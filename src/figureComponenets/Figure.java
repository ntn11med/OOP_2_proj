package figureComponenets;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure implements Drawable {
	private Color color;

	public Figure(Color color) {
		this.color = color;
	}

	public Figure() {
		this(Color.white);
	}

	@Override
	public final void draw(Graphics g) {
		Color oldColor = g.getColor();

		if (color != null)
			g.setColor(color);
		drawSpecific(g); // Call to template method
		g.setColor(oldColor);
	}

	// Template method pattern
	protected abstract void drawSpecific(Graphics g);
	
	public abstract void move(int dx, int dy);
	public abstract void moveTo(int x, int y);
	public abstract boolean encloses(int x, int y);

}