package com.shoppingCart.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	private static int ITEM_DESC_LEN = 100;
	
	@EmbeddedId
	private CartItem cartId;
	
//	private int userId;
//	
//	private int itemId;
	
	private String itemName;
	
	private String itemDescriptionShort;
	
	private int itemCount;

	public CartItem getCartId() {
		return cartId;
	}

	public void setCartId(CartItem cartId) {
		this.cartId = cartId;
	}

//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public int getItemId() {
//		return itemId;
//	}
//
//	public void setItemId(int itemId) {
//		this.itemId = itemId;
//	}
	
	

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescriptionShort() {
		return itemDescriptionShort;
	}

	public void setItemDescriptionShort(String itemDescriptionShort) {
		this.itemDescriptionShort =  itemDescriptionShort.length()> ITEM_DESC_LEN 
				? itemDescriptionShort.substring(0,ITEM_DESC_LEN).concat("...") : itemDescriptionShort;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	
	
	

}
