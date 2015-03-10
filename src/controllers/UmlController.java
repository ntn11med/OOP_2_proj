package controllers;

import model.ClassModel;

public class UmlController {
	private ClassModel classModel;

	public UmlController(ClassModel classModel) {
		this.classModel = classModel;
	}

	private void addComponent() {
		classModel.addComponent();

	}
	private void removeComponent(int index){
		classModel.removeComponent(index);
	}

}
