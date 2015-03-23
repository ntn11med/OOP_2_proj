package model;

public class AbstractRole implements ClassState {

	@Override
	public String getRole() {
		return "Abstract";
	}
	
	@Override
	public String toString() {
		return getRole();
	}
}
