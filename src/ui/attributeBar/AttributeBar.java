package ui.attributeBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.ClassData;

public class AttributeBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private String[] attr = new String[50];
	private int attrIndex = 0;
	private ClassData cd;
	private JScrollPane scroll;
	private JList<String> list;
	private JLabel lblText = new JLabel("Enter attribute:");
	private JTextField tbAttribute = new JTextField();
	private JButton btnAdd = new JButton("Add attr");
	private JButton btnRemove = new JButton("Remove attr");
	
	public AttributeBar() {
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
			attr = new String[50];
			attrIndex = 0;
			for (int i = 0; i < cd.getAttributes().size(); i++)
				attr[attrIndex++] = cd.getAttributes().get(i);
		}
		list.setListData(attr);
	}
	
	private void addListeners() {
		btnAdd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addToList();}});
		btnRemove.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {removeFromList();}});
	}
	
	private void addToList() {
		if (cd != null) {
			attr[attrIndex++] = tbAttribute.getText();
			list.setListData(attr);
			cd.addAttribute(tbAttribute.getText());
		}
	}
	
	private void removeFromList() {
		if (!list.isSelectionEmpty()) {
			attr[list.getSelectedIndex()] = "";
			list.setListData(attr);
			cd.removeAttribute(list.getSelectedIndex());
		}
	}
	
	private void setBounds() {
		lblText.setBounds(5, 5, 200, 20);
		tbAttribute.setBounds(5, 30, 190, 25);
		btnAdd.setBounds(5, 60, 120, 25);
		btnRemove.setBounds(5, 90, 120, 25);
		scroll.setBounds(5, 120, 190, 410);
	}
	
	private void addCtrls() {
		add(scroll);
		add(lblText);
		add(tbAttribute);
		add(btnAdd);
		add(btnRemove);
	}
}
