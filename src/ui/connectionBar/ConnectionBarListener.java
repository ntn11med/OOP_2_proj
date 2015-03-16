package ui.connectionBar;

public class ConnectionBarListener {
	private ConnectionBar panel;
	
	public ConnectionBarListener(ConnectionBar panel) {
		this.panel = panel;
	}
	
	public void addListeners() {
		panel.getBtnAdd().addActionListener(null);
		panel.getBtnRemove().addActionListener(null);
		panel.getListConnected().addKeyListener(null);
		panel.getListConnected().addMouseListener(null);
		panel.getListObjects().addKeyListener(null);
		panel.getListObjects().addMouseListener(null);
	}
}
