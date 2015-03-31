package graphicComponents;

import java.util.HashMap;
import java.util.Map;

public class ComponentFactory {
	private Map<String, ClassComponent> factoryMap;
	
	public ComponentFactory() {
		this.factoryMap = new HashMap<String, ClassComponent>();
		factoryMap.put("Class", new ClassComponent(0, 0));
		//factoryMap.put("Connector", new Connector(5, 5, 100, 0));
	}
	
	public ClassComponent getComponent(String input) {
		return factoryMap.get(input);
	}
}
