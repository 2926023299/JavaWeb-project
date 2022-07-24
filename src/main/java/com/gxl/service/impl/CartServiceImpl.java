package com.gxl.service.impl;

import com.gxl.dao.CartDao;
import com.gxl.dao.ProductDao;
import com.gxl.model.Cart;
import com.gxl.model.Product;
import com.gxl.service.CartService;
import com.gxl.utils.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.List;

public class CartServiceImpl implements CartService {

    @Override
    public void create(int id, String pid) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);
        CartDao cartMapper = sqlSession.getMapper(CartDao.class);
        ProductDao productMapper = sqlSession.getMapper(ProductDao.class);

        //判断是否已经存在
        Cart cart = cartMapper.hasCart(id, Integer.parseInt(pid));
        if (cart != null) {
            //如果存在，数量+1
            cart.setcNum(cart.getcNum() + 1);
            cartMapper.updateCart(cart);
        } else {
            //如果不存在，新建
            Product product = productMapper.findByPid(Integer.parseInt(pid));

            Cart newCart = new Cart();
            newCart.setcNum(1);
            newCart.setpId((int) product.getpId());
            newCart.setProduct(product);
            newCart.setuId(id);

            cartMapper.insert(newCart);

            sqlSession.close();
        }
    }

    @Override
    public List<Cart> findAll(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();

        CartDao mapper = sqlSession.getMapper(CartDao.class);

        List<Cart> list = mapper.findAll(uid);

        sqlSession.close();

        return list;
    }

    @Override
    public void delete(int parseInt) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);
        CartDao mapper = sqlSession.getMapper(CartDao.class);

        mapper.delete(parseInt);

        sqlSession.close();
    }

    /**
     * 更新购物车中商品数量
     * @param cid 购物车id
     * @param cNum 数量
     * @param pPrice 单价
     */
    @Override
    public void updateCartByNum(int cid, int cNum, int pPrice) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);
        CartDao mapper = sqlSession.getMapper(CartDao.class);

        BigDecimal totalPrice = new BigDecimal(cNum).multiply(new BigDecimal(pPrice));

        Cart cart = mapper.findByCid(cid);
        System.out.println(cart);
        cart.setcNum(cNum);
        cart.setcCount(totalPrice);

        mapper.updateCart(cart);

        sqlSession.close();
    }

    @Override
    public void clearCart(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);
        CartDao mapper = sqlSession.getMapper(CartDao.class);

        mapper.clearCart(uid);

        sqlSession.close();
    }
}
