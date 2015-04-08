package graphicComponents;

import figureComponenets.FigureMap;

public class ConnectorLineCalculator {
	private static FigureMap figureMap;

	public ConnectorLineCalculator(FigureMap figureMap) {
		ConnectorLineCalculator.figureMap = figureMap;
	}
	
	public static LineCoordinateTO calulateCoordinates(int x, int y, int key) {
		Point p = (Point) figureMap.get(key);
		return new LineCoordinateTO(x, y, p.x, p.y);
	}
}
