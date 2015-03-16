package ui.connectionBar;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ConnectionBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JList<String> listConnected = new JList<String>();
	private JScrollPane connectedScroll = new JScrollPane(listConnected);
	private JList<String> listObjects = new JList<String>();
	private JScrollPane objectScroll = new JScrollPane(listObjects);
	private JButton btnRemove = new JButton("Remove");
	private JButton btnAdd = new JButton("Add");
	private JLabel lblConnected = new JLabel("Current connections");
	private JLabel lblAllObjectsTo = new JLabel("All objects to connect to");
	
	public ConnectionBar() {
		setLayout(null);
		setBounds();
		addCtrls();
	}
	
	private void setBounds() {
		connectedScroll.setBounds(10, 36, 280, 253);
		btnRemove.setBounds(10, 300, 89, 23);
		btnAdd.setBounds(201, 300, 89, 23);
		lblConnected.setBounds(10, 11, 280, 14);
		lblAllObjectsTo.setBounds(10, 334, 280, 14);
		objectScroll.setBounds(10, 359, 280, 380);
	}
	
	private void addCtrls() {
		add(connectedScroll);
		add(btnRemove);
		add(btnAdd);
		add(lblConnected);
		add(lblAllObjectsTo);
		add(objectScroll);
	}
}
