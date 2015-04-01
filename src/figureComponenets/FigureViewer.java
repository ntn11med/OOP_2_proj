package figureComponenets;

import graphicComponents.Figure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class FigureViewer extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	protected FigureList figureList;
	protected FigureMap figureMap;

	public FigureViewer(FigureList figureList) {
		this.figureList = figureList;
		figureList.addObserver(this);
		setBackground(Color.blue);
	}
	
	public FigureViewer(FigureMap figureMap) {
		this.figureMap = figureMap;
		figureMap.addObserver(this);
		setBackground(Color.blue);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (figureList != null) {
			for (Figure figure : figureList)
				figure.draw(g);
		} else {
			for (Map.Entry<String, Figure> entry : figureMap.entrySet())
				entry.getValue().draw(g);
		}
	}
}