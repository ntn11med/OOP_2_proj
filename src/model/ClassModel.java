package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ClassModel extends Observable implements Observer {
	private Map<Integer, ClassData> modelMap = new HashMap<Integer, ClassData>();
	
	public void addComponent(Incrementor incr) {
		ClassData cd = new ClassData();
		cd.addObserver(this);
		modelMap.put(incr.readLast(), cd);
	}
	
	public ClassData getComponent(int key) {
		return modelMap.get(key);
	}
	
	public void removeComponent(int index) {
		modelMap.remove(index);
	}
	
	public Map<Integer, ClassData> getModels() {
		return modelMap;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setChanged();
		notifyObservers();
	}
}
