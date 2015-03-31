package ui.symbolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import figureComponenets.FigureList;
import graphicComponents.ClassComponent;

public class SymbolBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnClass = new JButton("Class");
	private JButton btnConnector = new JButton("Connector");
	private FigureList list;
	
	public SymbolBar(FigureList list) {
		add(btnClass);
		add(btnConnector);
		addListeners();
		this.list = list;
	}
	
	private void addListeners() {
		btnClass.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addClass();}});
		btnConnector.addActionListener(null);
	}
	
	private void addClass() {
		list.add(new ClassComponent(0, 0));
		list.update(null, null);
	}
}
