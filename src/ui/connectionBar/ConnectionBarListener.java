package ui.connectionBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import model.ClassData;
import model.ClassModel;

public class ConnectionBarListener {
	private ConnectionBar panel;
	private ClassData cd;
	private ClassModel cm;
	private String[] allConnections;
	private int[] allKeys;
	
	public ConnectionBarListener(ConnectionBar panel) {
		this.panel = panel;
	}
	
	public void updateClassData(ClassData cd) {
		this.cd = cd;
//		String [] tmp = {""};
//		panel.getListConnected().setListData(tmp);
		listSelectedConnections();
	}
	
	public void updateClassModel(ClassModel cm) {
		this.cm = cm;
		listAllConnections();
	}
	
	public void addListeners() {
		panel.getBtnAdd().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addConn();}});
		panel.getBtnRemove().addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {removeConn();}});
	}
	
	private void addConn() {
		if (!panel.getListObjects().isSelectionEmpty()) {
			cd.addAssociationName(panel.getListObjects().getSelectedValue());
			cd.addAssociationKey(allKeys[panel.getListObjects().getSelectedIndex()]);
			listSelectedConnections();
			listAllConnections();
		}
	}
	
	private void removeConn() {
		if (!panel.getListConnected().isSelectionEmpty()) {
			cd.removeAssociation(panel.getListConnected().getSelectedIndex());
			listSelectedConnections();
			listAllConnections();
		}
	}
	
	private void listAllConnections() {
		String [] tmp = {""};
		panel.getListObjects().setListData(tmp);
		if (cm.size() > 1) {
			int index = 0;
			allConnections = new String[cm.size()];
			allKeys = new int[cm.size()];
			for (Map.Entry<Integer, ClassData> entry : cm.entrySet())
				if (!entry.getValue().getName().equals(cd.getName())) {
					boolean noMatch = true;
					for (int i = 0; i < cd.getAssociations().size(); i++)
						if (cd.getAssociations().get(i).equals(entry.getValue().getName()))
							noMatch = false;
					if (noMatch) {
						allKeys[index] = entry.getKey();
						allConnections[index++] = entry.getValue().getName();
					}
				}
			panel.getListObjects().setListData(allConnections);
		}
	}
	
	private void listSelectedConnections() {
		String [] tmp = {""};
		panel.getListConnected().setListData(tmp);
		if (cd.getAssociations().size() > 0) {
			String [] connections = new String[cd.getAssociations().size()];
			for (int i = 0; i < cd.getAssociations().size(); i++)
				connections[i] = cd.getAssociations().get(i);
			panel.getListConnected().setListData(connections);
		}
	}
}
