package controllers;

import ui.mainFrame.MainFrame;
import model.ClassModel;
import model.Incrementor;

public class UmlController {
	private ClassModel classModel;
	private MainFrame mf;
	private Incrementor incr = new Incrementor();

	public UmlController(ClassModel classModel) {
		this.classModel = classModel;
		this.incr = new Incrementor();
		this.mf = new MainFrame();
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

}
