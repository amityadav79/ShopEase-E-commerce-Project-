package com.shopease.Services;

import com.shopease.Entities.CartItem;
import java.util.List;

public interface CartItemService {
    void saveCartItem(CartItem cartItem);
    CartItem getCartItemById(Long id);
    List<CartItem> getAllCartItems();
    void deleteCartItem(Long id);
}
