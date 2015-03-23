package model;

public class ClassRole implements ClassState {

	@Override
	public String getRole() {
		return "Class";
	}
	
	@Override
	public String toString() {
		return getRole();
	}
}
