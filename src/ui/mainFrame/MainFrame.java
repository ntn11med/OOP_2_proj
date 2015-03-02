package ui.mainFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import figureComponenets.MouseInteraction;
import figureComponenets.FigureList;
import figureComponenets.FigureViewer;
import graphicComponents.Circle;
import graphicComponents.ClassComponent;
import graphicComponents.Rectangle;
import ui.propertiesBar.PropertiesBar;
import ui.symbolBar.SymbolBar;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	FigureList figureList = new FigureList();
	FigureViewer figureViewer = new FigureViewer(figureList);

	public MainFrame() {
		setGUI();
		setBorderLayout();
		setVisible(true);
	}

	private void setGUI() {
		setSize(1000, 1000);
		//setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setBorderLayout() {
		JPanel panel = new JPanel();
		//Adding figures to panel
		figureList.add(new Circle(100, 100, 50));
		figureList.add(new Circle(200, 200, 25));
		figureList.add(new Circle(300, 300, 12));
		figureList.add(new Circle(400, 400, 8));
		figureList.add(new Rectangle(500, 500, 100, 100));
		figureList.add(new Rectangle(650, 650, 50, 50));
		figureList.add(new Rectangle(750, 750, 25, 25));
		figureList.add(new Rectangle(825, 825, 12, 12));
		figureList.add(new ClassComponent(150, 150, 50, 100));
		BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		panel.add(figureViewer,BorderLayout.CENTER);
		panel.add(new JButton("knapp"), BorderLayout.WEST);
		panel.add(new JButton("knapp"), BorderLayout.EAST);
		panel.add(new SymbolBar(),BorderLayout.NORTH);
		panel.add(new PropertiesBar(), BorderLayout.SOUTH);
		MouseInteraction mouseInteraction = new MouseInteraction(figureList);
		figureViewer.addMouseListener(mouseInteraction);
		figureViewer.addMouseMotionListener(mouseInteraction);
		setContentPane(panel);
	}

}
