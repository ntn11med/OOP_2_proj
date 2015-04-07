package controllers;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import figureComponenets.FigureMap;
import figureComponenets.MouseInteraction;
import graphicComponents.Figure;
import ui.mainFrame.MainFrame;
import model.ClassModel;
import model.Incrementor;

public class UmlController implements Observer {
	private ClassModel classModel;
	private MainFrame mf;
	private Incrementor incr = new Incrementor();
	private FigureMap map;
	private MouseInteraction mouseInteraction;

	public UmlController(ClassModel classModel) {
		this.classModel = classModel;
		this.incr = new Incrementor();
		this.map = new FigureMap();
		this.mouseInteraction = new MouseInteraction(map);
		mouseInteraction.addObserver(this);
		this.mf = new MainFrame(classModel, incr, map, mouseInteraction);
		mf.showFrame();
	}

	public UmlController() {
		this(new ClassModel());
	}

	public void addComponent() {
		classModel.addComponent(incr);

	}

	public void removeComponent(int index) {
		classModel.removeComponent(index);
	}

	@Override
	public void update(Observable o, Object arg) {
		for (Map.Entry<Integer, Figure> entry : map.entrySet())
			if (entry.getKey() == mouseInteraction.getSelectedKey())
				entry.getValue().updateData(classModel.getComponent(mouseInteraction.getSelectedKey()));
		mf.updateClassData(classModel.getComponent(mouseInteraction.getSelectedKey()));
		
	}

}
