package src;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatView extends JFrame {

	private JTextField textFieldInput;
	private JTextArea textAreaOutput;
	private JButton buttonSend;
	private JButton buttonQuit;
	private ObjectOutputStream outToServer;
	

	public ChatView() {
		super("View");

		initialize();
		addComponentsToFrame();
	}

	public void start() {
		buttonSend.addActionListener(new SendAction());
		buttonQuit.addActionListener(new QuitAction());
		setVisible(true);
		final String HOST = "localhost";
		final int PORT = 2910;
		try {

			Socket client = new Socket(HOST, PORT);
			updateMessages("Client> connected to server");

			outToServer = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());
			ClientReceiver r = new ClientReceiver(inFromServer, this);
			new Thread(r, "Receiver").start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			updateMessages("Could not connect");
		}

	}

	private void initialize() {
		textFieldInput = new JTextField();
		textAreaOutput = new JTextArea();
		textAreaOutput.setEditable(false);
		textAreaOutput.setBackground(Color.LIGHT_GRAY);
		buttonSend = new JButton("Send");
		buttonQuit = new JButton("Quit");
		setSize(400, 500); // set frame size
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textAreaOutput.setBackground(Color.ORANGE);
	}

	public void updateMessages(String message) {
		textAreaOutput.append(message + "\n");
	}

	private void addComponentsToFrame() {
		JPanel panelButtons = new JPanel();
		panelButtons.add(buttonSend);
		panelButtons.add(buttonQuit);

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(textFieldInput, BorderLayout.CENTER);
		panel1.add(panelButtons, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane(textAreaOutput);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(panel1, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		setContentPane(contentPane);
	}

	private class SendAction implements ActionListener {

		public SendAction() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Message message = new Message(textFieldInput.getText());
			// System.out.println("Cleint> " + message);
			try {
				outToServer.writeObject(message);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}

		private class QuitAction implements ActionListener {

			public QuitAction() {
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		}

	}

