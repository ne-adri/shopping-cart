package com.shoppingCart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shoppingCart.DTO.ItemDto;
import com.shoppingCart.entity.Cart;
import com.shoppingCart.repository.CartRepository;

@Service
public class CartService {
	
	private String UPDATED_PRODUCT_URL = "http://localhost:8081/product/isAvailable/{itemId}";

	RestTemplate restTemplate= new RestTemplate();

	@Autowired
	private CartRepository cartRepo;

//	public List<Cart> listAll(){
//		List<Cart> allProds = repo.findAll();
//		return allProds;
//	}

	public List<ItemDto> getCart(int userId) {
		List<Cart> cart = cartRepo.getItemsFromCart(userId);
		List<ItemDto> resp = new ArrayList<>();
		if (cart != null && cart.size() > 0) {
			for (Cart c : cart) {
				ItemDto obj = new ItemDto();
				obj.setItemId(c.getCartId().getItemId());
				obj.setUserId(c.getCartId().getUserId());
				obj.setDescription(c.getItemDescriptionShort());
				obj.setItemName(c.getItemName());
				obj.setQuantity(c.getItemCount());
				resp.add(obj);
			}
		} else {
			return null;
		}
		return resp;

	}

	public String addToCart(Cart cart) {
		String resp = "";
		try {
			int itemId = cart.getCartId().getItemId();
//			Call product service to see if avaiable to add to cart
			ResponseEntity<Object> response = restTemplate.getForEntity(UPDATED_PRODUCT_URL,Object.class);
			System.out.println(response);
//			Map<String, Object> obj = response.getBody();
			cartRepo.save(cart);
			resp = "Item Successfully added to cart";
		} catch (Exception ex) {
			resp = ex.toString();
		}
		return resp;
	}

	public String updateQuantityInCart(ItemDto itemToUpdate) {
		String resp = "";
		int itemId = itemToUpdate.getItemId();
		int userId = itemToUpdate.getUserId();
		int updatedQuantity = itemToUpdate.getQuantity();
		if(updatedQuantity<=0) {
			Map<String, Integer> itemInfo = new HashMap<>();
			itemInfo.put("userId", userId);
			itemInfo.put("itemId", itemId);
			deleteItemFromCart(itemInfo);
		}
		try {
			cartRepo.updateQuantity(itemId, userId, updatedQuantity);
			resp = "Quantity successfully updated in cart";
		} catch (Exception ex) {
			resp = "failed to update quantity : " + ex.toString();
		}
		return resp;

	}

	public boolean deleteItemFromCart(Map<String, Integer> itemInfo) {
		boolean resp = false;
		int itemId = itemInfo.get("itemId");
		int userId = itemInfo.get("userId");
		try {
			cartRepo.removeItemFromCart(itemId,userId);
			resp = true;
			
		}
		catch(Exception ex){
		}
		return resp;
	}
}
