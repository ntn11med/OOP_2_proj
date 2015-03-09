package graphicComponents;

import java.util.HashMap;
import java.util.Map;

public class ComponentFactory {
	private Map<String, Point> factoryMap;
	
	
	public ComponentFactory() {
		this.factoryMap = new HashMap<String, Point>();
		factoryMap.put("Class", new ClassComponent(0, 0));
		factoryMap.put("Connector", new Connector(5, 5, 100, 0));
	}
	
	public Point getComponent(String input) {
		return factoryMap.get(input);
	}
}
