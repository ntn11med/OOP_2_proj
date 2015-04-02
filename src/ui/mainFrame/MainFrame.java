package ui.mainFrame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import model.ClassModel;
import model.Incrementor;
import figureComponenets.FigureMap;
import figureComponenets.MouseInteraction;
import figureComponenets.FigureViewer;
import ui.attributeBar.AttributeBar;
import ui.connectionBar.ConnectionBar;
import ui.mainFrame.MainFrameMenuBar;
import ui.methodBar.MethodBar;
import ui.propertiesBar.PropertiesBar;
import ui.symbolBar.SymbolBar;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private FigureMap figureMap = new FigureMap();
	private FigureViewer figureViewer = new FigureViewer(figureMap);
	private MainFrameMenuBar menuBar = new MainFrameMenuBar();
	private SymbolBar sb;
	private PropertiesBar pb;
	private MethodBar mb = new MethodBar();
	private AttributeBar ab = new AttributeBar();
	private ConnectionBar cb = new ConnectionBar();

	public MainFrame(Incrementor incr, ClassModel cm) {
		sb = new SymbolBar(figureMap, incr);
		pb = new PropertiesBar(cm);
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
		JTabbedPane tp = new JTabbedPane();
		tp.addTab("Properties", pb);
		tp.addTab("Methods", mb);
		tp.addTab("Attributes", ab);
		tp.addTab("Connection", cb);
		tabPanel.add(tp);
		tabPanel.setBounds(0, 0, 200, 914);
		panel.add(tabPanel);
		figureViewer.setBounds(300, 40, 5000, 5000);
		figureViewer.setBounds(0, 0, 5000, 5000);
		JScrollPane jsp = new JScrollPane(figureViewer);
		jsp.setBounds(200, 40, 1500, 1000);
		panel.add(jsp);
		sb.setBounds(300, 0, 300, 40);
		panel.add(sb);
		MouseInteraction mouseInteraction = new MouseInteraction(figureMap);
		figureViewer.addMouseListener(mouseInteraction);
		figureViewer.addMouseMotionListener(mouseInteraction);
		setContentPane(panel);
	}
}
