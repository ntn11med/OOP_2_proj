package startup;

import javax.swing.SwingUtilities;
import controllers.UmlController;

public class Startup {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new UmlController();
			}
		});
	}
}
