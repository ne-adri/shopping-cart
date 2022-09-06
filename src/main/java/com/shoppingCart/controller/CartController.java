package com.shoppingCart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCart.DTO.ItemDto;
import com.shoppingCart.entity.Cart;
import com.shoppingCart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("/home")
	public String homePage() {
		return "index";
	}

//	@GetMapping("/all")
//	public List<Cart> list(){
//		return productService.listAll();
//	}

	@PostMapping("/add")
	public String addItemToCart(@RequestBody Cart cart) {
		String resp = cartService.addToCart(cart);
		return resp;

	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<List<ItemDto>> getCart(@PathVariable int userId) {
		List<ItemDto> resp = cartService.getCart(userId);
		if(resp!=null) {
			return new ResponseEntity<List<ItemDto>>(resp, HttpStatus.OK);
		}
		return new ResponseEntity<List<ItemDto>>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/quantity")
	public String updateQuantity(@RequestBody ItemDto item) {
		return cartService.updateQuantityInCart(item);
	}

	@DeleteMapping("/delete/item")
	public boolean deleteItemFromCart(@RequestBody Map<String,Integer> itemInfo) {
		boolean resp = cartService.deleteItemFromCart(itemInfo);
		return resp;
	}

}
