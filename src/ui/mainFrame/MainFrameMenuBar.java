package ui.mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrameMenuBar {
	JMenuBar menuBar = new JMenuBar();

	public MainFrameMenuBar() {
		setMenuBar();

	}

	public JMenuBar getMenu(){
		return menuBar;
	}
	private void setMenuBar() {
		//JMenuBar menuBar = new JMenuBar();
		// setJMenuBar(menuBar);
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
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(newAction, "New!");
			}
		});

		openAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(openAction, "Open!");
			}
		});

		saveAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(saveAction, "Save!");
			}
		});

		saveAsAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(saveAsAction, "Save As!");
			}
		});

		closeAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

}
