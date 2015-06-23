package com.zix.horsething.inventories;

import java.util.ArrayList;

import com.zix.horsething.items.Item;
import com.zix.horsething.manifest.GameManifest;

public class Inventory {
	
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Inventory() {
		items.add(GameManifest.getItem(0));
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
}
