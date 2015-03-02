package ui.propertiesBar;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;

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
	
	public PropertiesBar() {
		setBounds();
		addCtrls();
	}
	
	private void setBounds() {
	}
	
	private void addCtrls() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
