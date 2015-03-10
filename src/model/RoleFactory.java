package model;

import java.util.HashMap;
import java.util.Map;

public class RoleFactory {
	private Map<String, ClassState> roleMap;

	public RoleFactory() {
		this.roleMap = new HashMap<String, ClassState>();
		roleMap.put("Class", new ClassRole());
		roleMap.put("Abstract", new AbstractRole());
		roleMap.put("Interface", new InterfaceRole());
	}
	
	public ClassState getRole(String role) {
		return roleMap.get(role);
	}
}
