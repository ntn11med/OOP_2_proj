package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class ClassModel extends Observable implements Observer {
	private Map<Integer, ClassData> modelMap = new HashMap<Integer, ClassData>();
	private int size = 0;
	
	public void addComponent(Incrementor incr) {
		ClassData cd = new ClassData();
		cd.addObserver(this);
		modelMap.put(incr.readLast(), cd);
		size++;
	}
	
	public ClassData getComponent(int key) {
		return modelMap.get(key);
	}
	
	public void removeComponent(int index) {
		modelMap.remove(index);
		size--;
	}
	
	public Map<Integer, ClassData> getModels() {
		return modelMap;
	}
	
	public Set<Map.Entry<Integer, ClassData>> entrySet() {
		return modelMap.entrySet();
	}
	
	public int size() {
		return size;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setChanged();
		notifyObservers();
	}
}
