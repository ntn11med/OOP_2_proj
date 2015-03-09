package model;

import java.util.LinkedList;
import java.util.List;

public class ClassData {
	private String name;
	private List<String> attributes = new LinkedList<String>();
	private List<String> methods = new LinkedList<String>();
	private ClassState role;
	
	public ClassData() {
		this("Class");
	}
	
	public ClassData(String cs) {
		RoleFactory rf = new RoleFactory();
		role = rf.getRole(cs);
	}
}
