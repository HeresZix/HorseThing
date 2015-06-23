package com.zix.horsething.quests;

public abstract class LocationQuest extends Quest {

	private int xPos, yPos;
	
	public LocationQuest(String name, int xPos, int yPos) {
		super(QuestType.LOCATION, name);
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public abstract void questComplete();
	public abstract void questFailed();
}
