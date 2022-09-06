package com.shoppingCart.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CartItem  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	
	private int itemId;
	
//	public CartItem(CartItem cartId){
//		this.userId = cartId.getUserId();
//		this.itemId = cartId.getItemId();
//	}

	public int getUserId() {
		return userId;
	}

	public void setCartId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
