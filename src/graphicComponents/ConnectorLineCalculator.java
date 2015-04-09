package graphicComponents;

import figureComponenets.FigureMap;

public class ConnectorLineCalculator {
	private static FigureMap figureMap;

	public ConnectorLineCalculator(FigureMap figureMap) {
		ConnectorLineCalculator.figureMap = figureMap;
	}
	
	public static LineCoordinateTO calulateCoordinates(int x, int y, int key) {
		ClassComponent p = (ClassComponent) figureMap.get(key);
		return new LineCoordinateTO(x, y, p.dx, p.dy);
	}
}
