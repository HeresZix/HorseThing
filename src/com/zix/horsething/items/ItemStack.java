package com.zix.horsething.items;

public class ItemStack {
	
	private Item item;
	private int amount;
	
	public ItemStack(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}
	
	public Item getItem() {
		return item;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
}
