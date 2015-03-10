package model;

public class Incrementor {
	private int nr;
	
	public Incrementor() {
		nr = 0;
	}
	
	public int getSerialNr() {
		return ++nr;
	}
}
