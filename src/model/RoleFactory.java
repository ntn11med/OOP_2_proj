package model;

import java.util.HashMap;
import java.util.Map;

public class RoleFactory {
	private Map<String, ClassState> roleMap;

	public RoleFactory() {
		this.roleMap = new HashMap<String, ClassState>();
		roleMap.put("Class", new ClassRole());
	}

}
