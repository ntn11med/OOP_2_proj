package figureComponenets;

import graphicComponents.Figure;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class FigureMap extends Observable implements Observer {
	protected Map<String, Figure> figures = new HashMap<String, Figure>();
	
	public void add(String key, Figure figure) {
		figures.put(key, figure);
		notifyObservers();
	}

	public void remove(String key) {
		figures.remove(key);
		notifyObservers();
	}
	
	public Set<Map.Entry<String, Figure>> entrySet() {
		return figures.entrySet();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setChanged();
		notifyObservers();
	}
}
