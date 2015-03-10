package controllers;

import model.ClassModel;

public class UmlController {
	private ClassModel classModel;

	public UmlController(ClassModel classModel) {
		this.classModel = classModel;
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
