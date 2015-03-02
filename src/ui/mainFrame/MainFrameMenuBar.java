package ui.mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrameMenuBar {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");

	public MainFrameMenuBar() {
		setMenuBar();
	}

	public JMenuBar getMenu() {
		return menuBar;
	}

	private void setMenuBar() {
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		addFileMenuItems();
		addEditMenuItems();
	}

	private void addFileMenuItems() {
		JMenuItem newAction = new JMenuItem("New");
		JMenuItem openAction = new JMenuItem("Open");
		JMenuItem saveAction = new JMenuItem("Save");
		JMenuItem saveAsAction = new JMenuItem("Save As");
		JMenuItem closeAction = new JMenuItem("Exit");

		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.add(saveAction);
		fileMenu.add(saveAsAction);
		fileMenu.add(closeAction);

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

	private void addEditMenuItems() {
		JMenuItem redoAction = new JMenuItem("Redo");
		JMenuItem undoAction = new JMenuItem("Undo");
		JMenuItem cutAction = new JMenuItem("Cut");
		JMenuItem copyAction = new JMenuItem("Copy");
		JMenuItem pasteAction = new JMenuItem("Paste");
		
		editMenu.add(redoAction);
		editMenu.add(undoAction);
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		redoAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(cutAction, "Redo!");
			}
		});
		
		undoAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(cutAction, "Undo!");
			}
		});

		cutAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(cutAction, "Cut!");
			}
		});

		copyAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(copyAction, "Copy!");
			}
		});

		pasteAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(pasteAction, "Paste!");
			}
		});
	}
}
