package com.zix.horsething;

import java.util.ArrayList;

import javax.swing.JLabel;

import com.zix.horsething.inventories.Inventory;
import com.zix.horsething.quests.LocationQuest;
import com.zix.horsething.quests.Quest;

public class Player {
	
	public static Inventory inventory = new Inventory();
	public static Console console;
	public static JLabel locationLbl;
	public static ArrayList<Quest> quests = new ArrayList<Quest>();
	public static int xPos = 11;
	public static int yPos = -3;
	
	public static void assignQuest(Quest quest){
		quests.add(quest);
		console.printLine(quest.getName() + " - Started", true);
	}
	
	public static void updateQuests(){
		for(Quest quest : quests){
			if(quest instanceof LocationQuest){
				LocationQuest lQuest = (LocationQuest) quest;
				if((lQuest.getxPos() == xPos) && (lQuest.getyPos() == yPos)){
					console.printLine(lQuest.getName() + " - Completed", true);
					lQuest.questComplete();
				}
			}
		}
	}

	public static void updateLocation(){
		locationLbl.setText(xPos + ", " + yPos);
	}
	
	public static void processInput(String text) {
		if(text.equalsIgnoreCase("north")){
			moveNorth();
			updateQuests();
			updateLocation();
		} else if(text.equalsIgnoreCase("east")){
			moveEast();
			updateQuests();
			updateLocation();
		} else if(text.equalsIgnoreCase("south")){
			moveSouth();
			updateQuests();
			updateLocation();
		} else if(text.equalsIgnoreCase("west")){
			moveWest();
			updateQuests();
			updateLocation();
		}
	}
	
	public static void moveNorth(){ xPos++; }
	public static void moveEast(){ yPos++; }
	public static void moveSouth(){ xPos--; }
	public static void moveWest(){ yPos--; }
}















