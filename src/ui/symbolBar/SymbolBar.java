package ui.symbolBar;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SymbolBar extends JPanel {
	private static final long serialVersionUID = 1L;
	List<JButton> symbolButtonList = new LinkedList<JButton>();
	
	public SymbolBar() {
		symbolButtonList.add(new JButton("Class"));
		symbolButtonList.add(new JButton("Interface"));
		symbolButtonList.add(new JButton("Abs class"));
		drawButtons();
	}
	
	private void drawButtons() {
		for (JButton b : symbolButtonList)
			add(b);
	}
}
