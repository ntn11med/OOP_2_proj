package controllers;

import ui.mainFrame.MainFrame;
import model.ClassModel;
import model.Incrementor;

public class UmlController {
	private ClassModel classModel;
	private MainFrame mf;
	private Incrementor incr;

	public UmlController(ClassModel classModel) {
		this.classModel = classModel;
		this.mf = new MainFrame();
		this.incr = new Incrementor();
	}

	public UmlController() {
		this(new ClassModel());
	}

	public void addComponent() {
		classModel.addComponent();

	}

	public void removeComponent(int index) {
		classModel.removeComponent(index);
	}

}
