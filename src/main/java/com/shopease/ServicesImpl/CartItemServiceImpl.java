package com.shopease.ServicesImpl;

import com.shopease.dao.CartItemDAO;
import com.shopease.Entities.CartItem;
import com.shopease.Services.CartItemService;
import java.util.List;

public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO;

    public CartItemServiceImpl() {
        this.cartItemDAO = cartItemDAO;
    }

    @Override
    public void saveCartItem(CartItem cartItem) {
        cartItemDAO.saveCartItem(cartItem);
    }

    @Override
    public CartItem getCartItemById(Long id) {
        return cartItemDAO.getCartItemById(id);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemDAO.getAllCartItems();
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemDAO.deleteCartItem(id);
    }
}
