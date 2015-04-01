package model;

import java.util.HashMap;
import java.util.Map;

public class ClassModel {
	private Map<Integer, ClassData> modelMap = new HashMap<Integer, ClassData>();
	
	public void addComponent(Incrementor incr) {
		modelMap.put(incr.readLast(), new ClassData());
	}
	
	public void removeComponent(int index) {
		modelMap.remove(index);
	}
	
	public Map<Integer, ClassData> getModels() {
		return modelMap;
	}
}
