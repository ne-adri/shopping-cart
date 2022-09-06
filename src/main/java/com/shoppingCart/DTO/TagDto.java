package com.shoppingCart.DTO;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingCart.entity.Cart;

public class TagDto {
	
	private int tagId;
	private String tagName;
	
	@JsonIgnore
	private Set<Cart> products;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set<Cart> getProducts() {
		return products;
	}

	public void setProducts(Set<Cart> products) {
		this.products = products;
	}

	public int getTagId() {
		return tagId;
	}
	
	

}
