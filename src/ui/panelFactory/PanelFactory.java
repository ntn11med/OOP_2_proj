package ui.panelFactory;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import ui.attributeBar.AttributeBar;
import ui.connectionBar.ConnectionBar;
import ui.methodBar.MethodBar;
import ui.propertiesBar.PropertiesBar;
import ui.symbolBar.SymbolBar;


public class PanelFactory {
	private Map<String, JPanel> panelMap = new HashMap<String, JPanel>();
	
	public PanelFactory() {
		panelMap.put("MethodBar", new MethodBar());
		panelMap.put("PropertiesBar", new PropertiesBar());
		panelMap.put("AttributeBar", new AttributeBar());
		panelMap.put("ConnectionBar", new ConnectionBar());
		panelMap.put("SymbolBar", new SymbolBar());
	}
	
	public JPanel getPanel(String input) {
		return panelMap.get(input);
	}
}
