package model;

public class InterfaceRole implements ClassState {

	@Override
	public String getRole() {
		return "Interface";
	}
	
	@Override
	public String toString() {
		return "<< " + getRole() + " >>";
	}
}
