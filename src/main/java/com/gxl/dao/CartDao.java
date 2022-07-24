package com.gxl.dao;

import com.gxl.model.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartDao {

    Cart hasCart(@Param("uid") int uid,@Param("pid") int pid);

    void updateCart(Cart cart);

    void insert(Cart newCart);

    List<Cart> findAll(int uid);

    void delete(int parseInt);

    Cart findByCid(int cid);

    void clearCart(int uid);
}
