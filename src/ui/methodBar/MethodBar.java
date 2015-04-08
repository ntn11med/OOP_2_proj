package ui.methodBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.ClassData;

public class MethodBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private String[] methods = new String[50];
	private int methodIndex = 0;
	private ClassData cd;
	private JScrollPane scroll;
	private JList<String> list;
	private JLabel lblText = new JLabel("Enter method:");
	private JTextField tbMethod = new JTextField();
	private JButton btnAdd = new JButton("Add method");
	private JButton btnRemove = new JButton("Remove method");
	
	public MethodBar() {
		setLayout(null);
		list = new JList<String>();
		scroll = new JScrollPane(list);
		setBounds();
		addCtrls();
		addListeners();
	}
	
	public void updateClassData(ClassData cd) {
		this.cd = cd;
		if (cd != null) {
			methods = new String[50];
			methodIndex = 0;
			for (int i = 0; i < cd.getMethods().size(); i++)
				methods[methodIndex++] = cd.getMethods().get(i);
		}
		list.setListData(methods);
	}
	
	private void addListeners() {
		btnAdd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addToList();}});
		btnRemove.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {removeFromList();}});
	}
	
	private void addToList() {
		if (cd != null) {
			methods[methodIndex++] = tbMethod.getText();
			list.setListData(methods);
			cd.addMethod(tbMethod.getText());
		}
	}
	
	private void removeFromList() {
		if (!list.isSelectionEmpty()) {
			methods[list.getSelectedIndex()] = "";
			list.setListData(methods);
			cd.removeMethod(list.getSelectedIndex());
		}
	}
	
	private void setBounds() {
		lblText.setBounds(5, 5, 200, 20);
		tbMethod.setBounds(5, 30, 190, 25);
		btnAdd.setBounds(5, 60, 120, 25);
		btnRemove.setBounds(5, 90, 120, 25);
		scroll.setBounds(5, 120, 190, 410);
	}
	
	private void addCtrls() {
		add(scroll);
		add(lblText);
		add(tbMethod);
		add(btnAdd);
		add(btnRemove);
	}
}
