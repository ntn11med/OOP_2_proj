package ui.propertiesBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import model.ClassModel;

public class PropertiesBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblName = new JLabel("Name");
	private JLabel lblType = new JLabel("Type");
	private JTextField tbClassName = new JTextField();
	private JRadioButton rdbtnInterface = new JRadioButton("Interface");
	private JRadioButton rdbtnAbstractClass = new JRadioButton("Abstract Class");
	private JRadioButton rdbtnClass = new JRadioButton("Class");
	private JButton btnUpdate = new JButton("Update");
	private ClassModel cm;
	
	public PropertiesBar(ClassModel cm) {
		this.cm = cm;
		setLayout(null);
		setBounds();
		addCtrls();
		addListeners();
	}
	
	private void addListeners() {
		btnUpdate.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {addClassToModel();}});
	}
	
	private void addClassToModel() {
		cm.getComponent(1);
	}
	
	private void setBounds() {
		lblName.setBounds(10, 10, 150, 15);
		lblType.setBounds(10, 70, 150, 15);
		tbClassName.setBounds(10, 36, 150, 20);
		rdbtnInterface.setBounds(10, 90, 150, 25);
		rdbtnAbstractClass.setBounds(10, 120, 150, 25);
		rdbtnClass.setBounds(10, 145, 150, 25);
		btnUpdate.setBounds(10, 175, 90, 25);
	}
	
	private void addCtrls() {
		add(lblName);
		add(tbClassName);
		tbClassName.setColumns(15);
		add(lblType);
		buttonGroup.add(rdbtnInterface);
		add(rdbtnInterface);
		buttonGroup.add(rdbtnAbstractClass);
		add(rdbtnAbstractClass);
		buttonGroup.add(rdbtnClass);
		rdbtnClass.setSelected(true);
		add(rdbtnClass);
		add(btnUpdate);
	}
}
