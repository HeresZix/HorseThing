package com.zix.horsething.quests;

public class Quest {
	
	private QuestType type;
	private String name;
	//private boolean complete = false;
	
	public Quest(QuestType type, String name) {
		this.type = type;
		this.name = name;
	}

	public QuestType getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	//public boolean isComplete(){
	//	return complete;
	//}
	
	//public void setComplete(boolean complete) {
	//	this.complete = complete;
	//}
}
