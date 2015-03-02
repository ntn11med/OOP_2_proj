package figureComponenets;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class FigureViewer extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	protected FigureList figureList;

	public FigureViewer(FigureList figureList) {
		this.figureList = figureList;
		figureList.addObserver(this);
		setBackground(Color.blue);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

	@Override
	// Det är denna som anropas av swingtråden när det är dags att rita om
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Figure figure : figureList)
			figure.draw(g);
	}
}