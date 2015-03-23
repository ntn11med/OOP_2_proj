package model;

import java.util.LinkedList;
import java.util.List;

public class ClassData {
	private String name;
	private List<String> attributes = new LinkedList<String>();
	private List<String> methods = new LinkedList<String>();
	private ClassState role;
	private List<String> associations = new LinkedList<String>();
	private int maxLineLenght = 0;
	
	public ClassData() {
		this("Class");
	}
	
	public ClassData(String role) {
		setRole(role);
	}
	
	public void addAttribute(String attr) {
		checkSize(attr);
		attributes.add(attr);
	}
	
	public void removeAttribute(int index) {
		attributes.remove(index);
	}
	
	public void addMethod(String method) {
		checkSize(method);
		methods.add(method);
	}
	
	public void removeMethod(int index) {
		methods.remove(index);
	}
	
	public void setName(String name) {
		checkSize(name);
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
		checkSize(this.role.toString());
	}

	public ClassState getRole() {
		return role;
	}
	
	public void addAssociation(String input) {
		associations.add(input);
	}
	
	public void removeAssociation(int index) {
		associations.remove(index);
	}
	
	public List<String> getAssociations() {
		return associations;
	}
	
	public int getMaxLineLenght() {
		return maxLineLenght;
	}
	
	private void checkSize(String input) {
		if (input.length() > maxLineLenght)
			maxLineLenght = input.length(); 
	}
}
