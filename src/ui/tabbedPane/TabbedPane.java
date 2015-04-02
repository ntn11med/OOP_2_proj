package ui.tabbedPane;

import javax.swing.JTabbedPane;

import ui.attributeBar.AttributeBar;
import ui.connectionBar.ConnectionBar;
import ui.methodBar.MethodBar;
import ui.propertiesBar.PropertiesBar;

public class TabbedPane extends JTabbedPane {
	private static final long serialVersionUID = 1L;

	public TabbedPane() {
		JTabbedPane jtp = new JTabbedPane();
		makeTabs(jtp);
		repaint();
		setVisible(true);
	}

	private void makeTabs(JTabbedPane jtp) {
		jtp.addTab("methodBar", new MethodBar());
		jtp.addTab("propertiesBar", new PropertiesBar());
		jtp.addTab("AttributeBar", new AttributeBar());
		jtp.addTab("ConnectionBar", new ConnectionBar());
	}

}
