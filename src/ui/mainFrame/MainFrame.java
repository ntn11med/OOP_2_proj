package ui.mainFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
		// setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setBorderLayout() {
		JPanel panel = new JPanel();
		setMenuBar();

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
		BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		panel.add(figureViewer, BorderLayout.CENTER);
		panel.add(new JButton("knapp"), BorderLayout.WEST);
		panel.add(new JButton("knapp"), BorderLayout.EAST);
		panel.add(new SymbolBar(), BorderLayout.NORTH);
		panel.add(new PropertiesBar(), BorderLayout.SOUTH);
		MouseInteraction mouseInteraction = new MouseInteraction(figureList);
		figureViewer.addMouseListener(mouseInteraction);
		figureViewer.addMouseMotionListener(mouseInteraction);
		setContentPane(panel);
	}

	private void setMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		JMenuItem newAction = new JMenuItem("New");
		JMenuItem openAction = new JMenuItem("Open");
		JMenuItem saveAction = new JMenuItem("Save");
		JMenuItem saveAsAction = new JMenuItem("Save As");
		JMenuItem closeAction = new JMenuItem("Exit");
		
		JMenuItem cutAction = new JMenuItem("Cut");
		JMenuItem copyAction = new JMenuItem("Copy");
		JMenuItem pasteAction = new JMenuItem("Paste");

		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.add(saveAction);
		fileMenu.add(saveAsAction);
		fileMenu.add(closeAction);
		
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);

		newAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(newAction, "New!");}});
		
		openAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(openAction, "Open!");}});
		
		saveAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(saveAction, "Save!");}});
		
		saveAsAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(saveAsAction, "Save As!");}});
		
		closeAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {System.exit(0);
				
			}
		});

	}

}
