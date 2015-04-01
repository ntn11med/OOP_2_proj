package figureComponenets;

import graphicComponents.Figure;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class FigureMap extends Observable implements Observer {
	protected Map<Integer, Figure> figures = new HashMap<Integer, Figure>();
	
	public void add(Integer key, Figure figure) {
		figures.put(key, figure);
		notifyObservers();
	}

	public void remove(Integer key) {
		figures.remove(key);
		notifyObservers();
	}
	
	public Set<Map.Entry<Integer, Figure>> entrySet() {
		return figures.entrySet();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setChanged();
		notifyObservers();
	}
}
