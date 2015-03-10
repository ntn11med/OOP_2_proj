package model;

import java.util.HashMap;
import java.util.Map;

public class ClassModel {
	private Map<Integer, ClassData> modelMap = new HashMap<Integer, ClassData>();
	private Incrementor incr = new Incrementor();
	
	public void addComponent() {
		modelMap.put(incr.getSerialNr(), new ClassData());
	}
	
	public void removeComponent(int index) {
		modelMap.remove(index);
	}
	
	public Map<Integer, ClassData> getModels() {
		return modelMap;
	}
}
