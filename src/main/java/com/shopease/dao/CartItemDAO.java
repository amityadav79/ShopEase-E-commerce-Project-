package com.shopease.dao;

import com.shopease.Entities.CartItem;
import java.util.List;

public interface CartItemDAO {
    void saveCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    CartItem getCartItemById(Long id);
    List<CartItem> getCartItemsByUserId(Long userId);
    List<CartItem> getAllCartItems();  // Missing method added
    void deleteCartItem(Long id);
}
