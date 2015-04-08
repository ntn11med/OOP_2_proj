package ui.connectionBar;

import java.util.Map;
import model.ClassData;
import model.ClassModel;

public class ConnectionBarListener {
	private ConnectionBar panel;
	private ClassData cd;
	private ClassModel cm;
	private String[] allConnections;
	
	public ConnectionBarListener(ConnectionBar panel) {
		this.panel = panel;
	}
	
	public void updateClassData(ClassData cd) {
		this.cd = cd;
	}
	
	public void updateClassModel(ClassModel cm) {
		this.cm = cm;
		listSelectedConnections();
	}
	
	public void addListeners() {
		panel.getBtnAdd().addActionListener(null);
		panel.getBtnRemove().addActionListener(null);
		panel.getListConnected().addKeyListener(null);
		panel.getListConnected().addMouseListener(null);
		panel.getListObjects().addKeyListener(null);
		panel.getListObjects().addMouseListener(null);
	}
	
	private void listAllConnections() {
		
	}
	
	private void listSelectedConnections() {
		if (cm.size() > 1) {
			int index = 0;
			allConnections = new String[cm.size()];
			for (Map.Entry<Integer, ClassData> entry : cm.entrySet())
				if (!entry.getValue().getName().equals(cd.getName()))
					allConnections[index++] = entry.getValue().getName();
			panel.getListObjects().setListData(allConnections);
		}
	}
}
