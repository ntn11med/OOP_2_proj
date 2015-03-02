package figureComponenets;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import graphicComponents.Figure;
import figureComponenets.FigureList;
import graphicComponents.Point;

public class MouseInteraction extends Observable implements MouseListener, MouseMotionListener {
	private Figure selectedFigure = new Point();
	private FigureList list;
	
	public MouseInteraction(FigureList list) {
		this.list = list;
		addObserver(list);
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
		for (Figure figure : list)
			if (figure.encloses(e.getX(), e.getY()))
				selectedFigure = figure;
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
		for (Figure figure : list)
			if (figure.encloses(e.getX(), e.getY()))
				selectedFigure = figure;
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
