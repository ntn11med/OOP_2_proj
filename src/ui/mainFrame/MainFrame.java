package ui.mainFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import figureComponenets.MouseInteraction;
import figureComponenets.FigureList;
import figureComponenets.FigureViewer;
import graphicComponents.Circle;
import graphicComponents.ClassComponent;
import graphicComponents.Rectangle;
import graphicComponents.Text;
import ui.mainFrame.MainFrameMenuBar;
import ui.symbolBar.SymbolBar;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private FigureList figureList = new FigureList();
	private FigureViewer figureViewer = new FigureViewer(figureList);
	private MainFrameMenuBar menuBar = new MainFrameMenuBar();
	private SymbolBar sb = new SymbolBar();

	public MainFrame() {
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
		figureList.add(new Circle(100, 100, 50));
		figureList.add(new Circle(200, 200, 25));
		figureList.add(new Circle(300, 300, 12));
		figureList.add(new Circle(400, 400, 8));
		figureList.add(new Rectangle(500, 500, 100, 100));
		figureList.add(new Rectangle(650, 650, 50, 50));
		figureList.add(new Rectangle(750, 750, 25, 25));
		figureList.add(new Rectangle(825, 825, 12, 12));
		figureList.add(new ClassComponent(150, 150, 50, 100));
		figureList.add(new Text(155, 155, "Klass namn"));
		figureViewer.setBounds(0, 0, 5000, 5000);
		JScrollPane jsp = new JScrollPane(figureViewer);
		jsp.setBounds(300, 40, 1500, 1000);
		panel.add(jsp);
		sb.setBounds(300, 0, 300, 40);
		panel.add(sb);
		MouseInteraction mouseInteraction = new MouseInteraction(figureList);
		figureViewer.addMouseListener(mouseInteraction);
		figureViewer.addMouseMotionListener(mouseInteraction);
		setContentPane(panel);
	}

}
