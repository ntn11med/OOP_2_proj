package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class ClassData extends Observable {
	private String name = "";
	private List<String> attributes = new LinkedList<String>();
	private List<String> methods = new LinkedList<String>();
	private ClassState role;
	private List<String> associations = new LinkedList<String>();
	private List<Integer> associationKeys = new LinkedList<Integer>();
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
		notifyer();
	}
	
	public void removeAttribute(int index) {
		attributes.remove(index);
		notifyer();
	}
	
	public void addMethod(String method) {
		checkSize(method);
		methods.add(method);
		notifyer();
	}
	
	public void removeMethod(int index) {
		methods.remove(index);
		notifyer();
	}
	
	public void setName(String name) {
		checkSize(name);
		this.name = name;
		notifyer();
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
		notifyer();
	}

	public ClassState getRole() {
		return role;
	}
	
	public void addAssociationName(String input) {
		associations.add(input);
		notifyer();
	}
	
	public void addAssociationKey(Integer input) {
		associationKeys.add(input);
		notifyer();
	}
	
	public void removeAssociation(int index) {
		associations.remove(index);
		associationKeys.remove(index);
		notifyer();
	}
	
	public List<String> getAssociations() {
		return associations;
	}
	
	public List<Integer> getAssociationKeys() {
		return associationKeys;
	}
	
	public int getMaxLineLenght() {
		return maxLineLenght;
	}
	
	private void checkSize(String input) {
		if (input.length() > maxLineLenght)
			maxLineLenght = input.length(); 
	}
	
	private void notifyer() {
		setChanged();
		notifyObservers();
	}
}