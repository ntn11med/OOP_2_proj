package graphicComponents;

public class ComponentFactorySingleton {
	private int nr;
	private static ComponentFactory cf;
	
	public ComponentFactorySingleton() {
		this.nr = 1;
	}
	
	public static ComponentFactory getInstance() {
		if (cf == null)
			cf = new ComponentFactory();
		return cf;
	}
	
	public int getNextNr() {
		return nr++;
	}
}
