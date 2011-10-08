package model;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

/**
 * a class which is the view of the server
 * 
 * @author jxx084
 */
public class ServerView extends JPanel implements Observer {

	private ServerModel model;

	private ImageIcon serverStart;
	private ImageIcon serverStop;
	private ImageIcon startIco;

	private JLabel server;
	private JButton startButton;

	private JLabel startLabel;

	/**
	 * to create a server view base on a server model
	 * 
	 * @param model
	 *            the underlying server model
	 */
	public ServerView(final ServerModel model) {
		super();
		// read the image file
		URL startUrl = this.getClass().getResource(
				"/serverimages/serverstart.png");
		serverStart = new ImageIcon(startUrl);
		URL stopUrl = this.getClass().getResource(
				"/serverimages/serverstop.png");
		serverStop = new ImageIcon(stopUrl);
		URL startTwoUrl = this.getClass()
				.getResource("/serverimages/start.png");
		startIco = new ImageIcon(startTwoUrl);
		URL stopTwoUrl = this.getClass().getResource("/serverimages/stop.png");

		server = new JLabel();
		server.setIcon(serverStop);

		this.model = model;

		startButton = new JButton();
		startButton.setIcon(startIco);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						model.setStart(true);
						model.startServer();
					}
				}).start();

			}
		});

		startLabel = new JLabel("start");

		setLayout(new GridLayout(1, 2));

		JPanel left = new JPanel();
		left.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.insets = new Insets(5, 5, 5, 5);

		constraints.ipadx = -15;
		constraints.ipady = -5;
		constraints.gridx = 0;
		constraints.gridy = 0;
		left.add(startButton, constraints);

		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.gridx = 1;
		constraints.gridy = 0;
		left.add(startLabel, constraints);

		constraints.ipadx = -15;
		constraints.ipady = -5;
		constraints.gridx = 0;
		constraints.gridy = 1;

		add(left);
		add(server);
	}

	public void update(Observable obs, Object obj) {
		if (model.isStart()) {
			startButton.setEnabled(false);
			server.setIcon(serverStart);
		} else {
			startButton.setEnabled(true);
			server.setIcon(serverStop);
		}
	}

}
