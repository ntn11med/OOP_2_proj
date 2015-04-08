package ui.connectionBar;

import model.ClassData;

public class ConnectionBarListener {
	private ConnectionBar panel;
	private ClassData cd;
	
	public ConnectionBarListener(ConnectionBar panel) {
		this.panel = panel;
	}
	
	public void updateClassData(ClassData cd) {
		this.cd = cd;
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
