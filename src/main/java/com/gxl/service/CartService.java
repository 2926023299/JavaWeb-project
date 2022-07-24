package com.gxl.service;

import com.gxl.model.Cart;

import java.util.List;

public interface CartService {

    void create(int id, String pid);

    List<Cart> findAll(int uid);

    void delete(int parseInt);

    void updateCartByNum(int cid, int cNum, int pPrice);

    void clearCart(int uid);
}
