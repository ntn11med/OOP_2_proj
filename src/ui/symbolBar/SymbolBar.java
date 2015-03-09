package ui.symbolBar;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SymbolBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnClass = new JButton("Class");
	private JButton btnConnector = new JButton("Connector");
	
	public SymbolBar() {
		add(btnClass);
		add(btnConnector);
		addListeners();
	}
	
	private void addListeners() {
		btnClass.addActionListener(null);
		btnConnector.addActionListener(null);
	}
}
