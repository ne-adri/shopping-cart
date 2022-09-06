package com.shoppingCart.DTO;


public class ItemDto {

	private int itemId;
	private String itemName;
	private String description;
	private int userId;
	private int quantity;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int cartItem) {
		this.itemId = cartItem;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
	
