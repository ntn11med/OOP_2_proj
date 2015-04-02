package ui.mainFrame;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Incrementor;
import figureComponenets.FigureMap;
import figureComponenets.MouseInteraction;
import figureComponenets.FigureList;
import figureComponenets.FigureViewer;
import graphicComponents.ComponentFactory;
import graphicComponents.ComponentFactorySingleton;
import graphicComponents.Text;
import ui.attributeBar.AttributeBar;
import ui.connectionBar.ConnectionBar;
import ui.mainFrame.MainFrameMenuBar;
import ui.methodBar.MethodBar;
import ui.propertiesBar.PropertiesBar;
import ui.symbolBar.SymbolBar;
import ui.tabbedPane.TabbedPane;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private FigureList figureList = new FigureList();
	private FigureMap figureMap = new FigureMap();
	private FigureViewer figureViewer = new FigureViewer(figureMap);
	private MainFrameMenuBar menuBar = new MainFrameMenuBar();
	private SymbolBar sb; 
	private PropertiesBar pb = new PropertiesBar();
	private MethodBar mb = new MethodBar();
	private AttributeBar ab = new AttributeBar();
	private ConnectionBar cb = new ConnectionBar();
	private ComponentFactory cf;

	public MainFrame(Incrementor incr) {
		cf = ComponentFactorySingleton.getInstance();
		sb = new SymbolBar(figureMap, incr);
		setGUI();
		setBorderLayout();
		setJMenuBar(menuBar.getMenu());
	}

	public void showFrame() {
		setVisible(true);
	}

	private void setGUI() {
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setBorderLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JPanel tabPanel = new JPanel();
		tabPanel.setLayout(new GridLayout());
		TabbedPane tp = new TabbedPane();
		tp.addTab("1", pb);
		tp.addTab("2", mb);
		tp.addTab("3", ab);
		tp.addTab("4", cb);
		tabPanel.add(tp);
		tabPanel.setBounds(0, 13, 200, 901);
		panel.add(tabPanel);
		
		figureViewer.setBounds(0, 0, 5000, 5000);
		JScrollPane jsp = new JScrollPane(figureViewer);
		jsp.setBounds(200, 40, 1500, 1000);
		panel.add(jsp);
		sb.setBounds(300, 0, 300, 40);
		panel.add(sb);
		MouseInteraction mouseInteraction = new MouseInteraction(figureMap);
		// sb.setBounds(300, 0, 300, 40);
		// panel.add(sb);
		// pb.setBounds(0, 0, 200, 200);
		// panel.add(pb);
		figureViewer.addMouseListener(mouseInteraction);
		figureViewer.addMouseMotionListener(mouseInteraction);
		setContentPane(panel);
	}

}
