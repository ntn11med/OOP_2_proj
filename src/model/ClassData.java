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
	
	public ClassData(String role) {
		setRole(role);
	}
	
	public void addAttribute(String attr) {
		attributes.add(attr);
	}
	
	public void removeAttribute(int index) {
		attributes.remove(index);
	}
	
	public void removeAttribute(String attr) {
		attributes.remove(attr);
	}
	
	public void addMethod(String method) {
		methods.add(method);
	}
	
	public void removeMethod(int index) {
		methods.remove(index);
	}
	
	public void removeMethod(String method) {
		methods.remove(method);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public List<String> getMethods() {
		return methods;
	}
	
	public void setRole(String role) {
		RoleFactory rf = new RoleFactory();
		this.role = rf.getRole(role);
	}

	public ClassState getRole() {
		return role;
	}
}
