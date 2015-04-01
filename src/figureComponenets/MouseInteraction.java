package figureComponenets;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Map;
import java.util.Observable;

import graphicComponents.Figure;
import figureComponenets.FigureList;
import graphicComponents.Point;

public class MouseInteraction extends Observable implements MouseListener, MouseMotionListener {
	private Figure selectedFigure = new Point();
	private FigureList list;
	private FigureMap map;
	
	public MouseInteraction(FigureList list) {
		this.list = list;
		addObserver(list);
	}
	
	public MouseInteraction(FigureMap map) {
		this.map = map;
		addObserver(map);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (selectedFigure!=null) {
			selectedFigure.moveTo(e.getX(), e.getY());
			notifyer();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Figure currentFig = selectedFigure;
		if (list != null) {
			for (Figure figure : list)
				if (figure.encloses(e.getX(), e.getY()))
					selectedFigure = figure;
		} else {
			Figure fig;
			for (Map.Entry<Integer, Figure> entry : map.entrySet()) {
				fig = entry.getValue();
				if (fig.encloses(e.getX(), e.getY()))
					selectedFigure = fig;
			}
		}
		if (!currentFig.equals(selectedFigure)) {
			currentFig.setSelected(false);
			selectedFigure.setSelected(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Figure currentFig = selectedFigure;
		if (list != null) {
			for (Figure figure : list)
				if (figure.encloses(e.getX(), e.getY()))
					selectedFigure = figure;
		} else {
			Figure fig;
			for (Map.Entry<Integer, Figure> entry : map.entrySet()) {
				fig = entry.getValue();
				if (fig.encloses(e.getX(), e.getY()))
					selectedFigure = fig;
			}
		}
		if (!currentFig.equals(selectedFigure)) {
			currentFig.setSelected(false);
			selectedFigure.setSelected(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		notifyer();
	}
	
	private void notifyer() {
		setChanged();
		notifyObservers();
	}

}
