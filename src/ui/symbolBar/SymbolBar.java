package ui.symbolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Incrementor;
import figureComponenets.FigureList;
import figureComponenets.FigureMap;
import graphicComponents.ClassComponent;

public class SymbolBar extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private JButton btnClass = new JButton("Class");
	private JButton btnConnector = new JButton("Connector");
	private FigureList list;
	private FigureMap map;
	private Incrementor incr;
	
	public SymbolBar(FigureList list) {
		add(btnClass);
		add(btnConnector);
		addListeners();
		this.list = list;
		this.incr = new Incrementor();
	}
	
	public SymbolBar(FigureMap map, Incrementor incr) {
		add(btnClass);
		add(btnConnector);
		addListeners();
		this.map = map;
		this.incr = incr;

	}
	
	private void addListeners() {
		btnClass.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addClass();}});
		btnConnector.addActionListener(null);
	}
	
	private void addClass() {
		if ( list != null) {
			list.add(new ClassComponent(0, 0));
			list.update(null, null);
		} else {
			map.add(incr.getSerialNr(), new ClassComponent(0, 0));
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		
	}
}
