package com.zix.horsething;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.zix.horsething.manifest.GameManifest;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GameWindow {

	private JFrame frame;
	private JTextField txtInput;
	private JTextPane pneConsole;
	private JLabel lblLocation;
	
	private Game game;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameWindow() {
		initialize();
		game = new Game(pneConsole, txtInput, lblLocation);
		game.start();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlWorld = new JPanel();
		tabbedPane.addTab("World", null, pnlWorld, null);
		pnlWorld.setLayout(null);
		
		pneConsole = new JTextPane();
		pneConsole.setText("Welcome to HorseThing!");
		pneConsole.setEditable(false);
		pneConsole.setBounds(10, 36, 844, 372);
		pnlWorld.add(pneConsole);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtInput.getText().equalsIgnoreCase("")){
					Player.processInput(txtInput.getText());
					txtInput.setText("");
				}
			}
		});
		btnSubmit.setBounds(765, 419, 89, 20);
		pnlWorld.add(btnSubmit);
		
		txtInput = new JTextField();
		txtInput.setBounds(10, 419, 745, 20);
		pnlWorld.add(txtInput);
		txtInput.setColumns(10);
		
		lblLocation = new JLabel("location");
		lblLocation.setBounds(10, 11, 336, 14);
		pnlWorld.add(lblLocation);
		
		JPanel pnlInventory = new JPanel();
		tabbedPane.addTab("New tab", null, pnlInventory, null);
	}
	
	public void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
