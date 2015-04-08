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
		setChanged();
		notifyObservers();
	}
	
	public Figure get(int key) {
		return figures.get(key);
	}

	public void remove(Integer key) {
		figures.remove(key);
		setChanged();
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
