package com.zix.horsething.manifest;

import java.util.ArrayList;

import com.zix.horsething.items.Item;

public class GameManifest {
	
	private static ArrayList<Item> items = new ArrayList<Item>();
	
	public static void registerItems(){
		items.add(new Item("Cookie", "A delicous cookie!", 0));
	}
	
	public static ArrayList<Item> getItems() {
		return items;
	}
	
	public static Item getItem(int id){
		for(Item i : items){
			if(i.getId() == id) return i;
		}
		return null;
	}
}
