package controllers;

import java.util.Observable;
import java.util.Observer;

import ui.mainFrame.MainFrame;
import model.ClassModel;
import model.Incrementor;

public class UmlController implements Observer {
	private ClassModel classModel;
	private MainFrame mf;
	private Incrementor incr = new Incrementor();

	public UmlController(ClassModel classModel) {
		this.classModel = classModel;
		this.incr = new Incrementor();
		this.mf = new MainFrame(incr);
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
		// TODO Auto-generated method stub
		
	}

}
