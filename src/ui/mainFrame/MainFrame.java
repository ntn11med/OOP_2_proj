package ui.mainFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import figureComponenets.MouseInteraction;
import figureComponenets.FigureList;
import figureComponenets.FigureViewer;
import graphicComponents.ComponentFactory;
import graphicComponents.ComponentFactorySingleton;
import graphicComponents.Text;
import ui.mainFrame.MainFrameMenuBar;
import ui.propertiesBar.PropertiesBar;
import ui.symbolBar.SymbolBar;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private FigureList figureList = new FigureList();
	private FigureViewer figureViewer = new FigureViewer(figureList);
	private MainFrameMenuBar menuBar = new MainFrameMenuBar();
	private SymbolBar sb = new SymbolBar();
	private PropertiesBar pb = new PropertiesBar();
	private ComponentFactory cf;

	public MainFrame() {
		cf = ComponentFactorySingleton.getInstance();
		setGUI();
		setBorderLayout();
		setJMenuBar(menuBar.getMenu());
		setVisible(true);
	}

	private void setGUI() {
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setBorderLayout() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		// Adding figures to panel
		figureList.add(cf.getComponent("Class"));
		figureList.add(cf.getComponent("Connector"));
		figureList.add(new Text(155, 155, "Klass namn"));
		figureViewer.setBounds(0, 0, 5000, 5000);
		JScrollPane jsp = new JScrollPane(figureViewer);
		jsp.setBounds(200, 40, 1500, 1000);
		panel.add(jsp);
		sb.setBounds(300, 0, 300, 40);
		panel.add(sb);
		pb.setBounds(0, 0, 200, 200);
		panel.add(pb);
		MouseInteraction mouseInteraction = new MouseInteraction(figureList);
		figureViewer.addMouseListener(mouseInteraction);
		figureViewer.addMouseMotionListener(mouseInteraction);
		setContentPane(panel);
	}

}
