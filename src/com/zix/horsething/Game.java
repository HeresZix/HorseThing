package com.zix.horsething;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.zix.horsething.manifest.GameManifest;
import com.zix.horsething.quests.TestQuest;

public class Game extends Thread {
	
	private Console console;
	private JTextField inputField;
	private JLabel locationLbl;
	
	public Game(JTextPane textPane, JTextField textField, JLabel label) {
		this.console = new Console(textPane);
		this.inputField = textField;
		this.locationLbl = label;
		Player.console = console;
		Player.locationLbl = label;
		Player.updateLocation();
		//Player.quests.add(new TestQuest());
		GameManifest.registerItems();
	}
	
	public void run() {
		inputField.setEnabled(false);
		console.typeLine("You slowly start opening your eyes, a throbbing pain is lingering in the back of your head. 2 figures are emerging in your blurred vision.", true, 20);
		pause(2000);
		console.characterType("???", "Sir, he is waking up.", true);
		pause(1000);
		console.characterType("???", "Take it slow now.", true);
		pause(300);
		console.typeLine("\"Where am I?\" you think to yourself.", true, 20);
		pause(200);
		console.typeLine("Someone puts hand on the back of your head and helps you sit up on the edge of a medical bed.", true, 20);
		pause(200);
		console.typeLine("A stallion stands before you, wearing royal armour. You regain your memory and realize where you are.", true, 20);
		pause(1000);
		console.characterType("Royal Guard", "You handled yourself well with those bandits, not well enough though. Luckily we found you.", true);
		Player.updateQuests();
		inputField.setEnabled(true);
	}
	
	public void pause(long millis){
		try {
			sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
