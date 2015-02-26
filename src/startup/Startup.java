package startup;

import javax.swing.SwingUtilities;

public class Startup {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//new FigureDrawProgram();
			}
		});
	}
}
