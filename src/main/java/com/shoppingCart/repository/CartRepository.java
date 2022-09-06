package com.shoppingCart.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingCart.entity.Cart;
import com.shoppingCart.entity.CartItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartItem>{
	
	@Query(value="SELECT * FROM product WHERE NAME LIKE %:name%",nativeQuery = true)
	public List<Cart> findProductsByName(@Param("name") String name);
	
	@Query(value="SELECT * FROM cart WHERE user_id = :userId",nativeQuery = true)
	public List<Cart> getItemsFromCart(@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query(value="UPDATE cart set item_count = :quantity WHERE user_id = :userId and item_id = :itemId",nativeQuery = true)
	public void updateQuantity(@Param("itemId") int itemId,@Param("userId") int userId,
			@Param("quantity") int quantity);
	
	@Transactional
	@Modifying
	@Query(value="DELETE from cart where item_id = :itemId and user_id = :userId",nativeQuery = true)
	public void removeItemFromCart(@Param("itemId") int itemId, @Param("userId") int userId);
//	@Query(value = "UPDATE cart  ")
//	public Cart saveToCart(Cart cart);

}
