package startup;

import javax.swing.SwingUtilities;

import ui.mainFrame.MainFrame;

public class Startup {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();
			}
		});
	}
}
