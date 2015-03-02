package figureComponenets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class FigureList extends Observable implements Iterable<Figure>, Observer {
	protected LinkedList<Figure> figures = new LinkedList<Figure>();

	public void add(Figure figure) {
		figures.add(figure);
		notifyObservers();
	}

	public void remove(Figure figure) {
		figures.remove(figure);
		notifyObservers();
	}

	public Iterator<Figure> iterator() {
		return figures.iterator();
	}

	@Override // eg if a part is changed
	public void update(Observable arg0, Object arg1) {
		setChanged();
		notifyObservers(); //then pass it along
	}

}
