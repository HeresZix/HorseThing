package com.zix.horsething.items;

public class Item {

	private String name;
	private String description;
	private int id;
	
	public Item(String name, String desc, int id) {
		this.name = name;
		this.description = desc;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getId() {
		return id;
	}
}
