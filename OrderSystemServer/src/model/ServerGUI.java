package model;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class ServerGUI {
	public static void main(String[] args) {
		final ServerModel model = new ServerModel();
		ServerView view = new ServerView(model);
		model.addObserver(view);
		JFrame frame = new JFrame("Server");

		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				model.getDBConn().closeConnection();
			}

			public void windowActivated(WindowEvent arg0) {
			}

			public void windowClosed(WindowEvent arg0) {
			}

			public void windowDeactivated(WindowEvent arg0) {
			}

			public void windowDeiconified(WindowEvent arg0) {
			}

			public void windowIconified(WindowEvent arg0) {
			}

			public void windowOpened(WindowEvent arg0) {
			}

		});
		
		frame.add(view);
		frame.setVisible(true);
	}

}

