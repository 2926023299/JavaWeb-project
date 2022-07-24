package com.gxl.service.impl;

import com.gxl.dao.ItemDao;
import com.gxl.dao.OrderDao;
import com.gxl.model.Cart;
import com.gxl.model.Item;
import com.gxl.model.Orders;
import com.gxl.service.CartService;
import com.gxl.service.OrderService;
import com.gxl.utils.MybatisTool;
import com.gxl.utils.RandomUtils;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public Orders create(int uid, int aid, double total) {
        //创建订单对象
        Orders orders = new Orders();
        orders.setoId(RandomUtils.createOrderId());
        orders.setaId(aid);
        orders.setuId(uid);
        orders.setoTime(new Date());
        orders.setoCount(BigDecimal.valueOf(total));
        orders.setoState(1);

        //保存订单对象
        SqlSession sqlSession = MybatisTool.getSqlSession();
        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        mapper.insertOrders(orders);

        //将购物车转为订单项
        CartService cartService = new CartServiceImpl();
        List<Cart> cartList = cartService.findAll(uid);

        List<Item> items = new ArrayList<>();
        for(Cart cart : cartList) {
            Item item = new Item();
            item.setoId(orders.getoId());
            item.setpId(cart.getpId());
            item.setiCount(cart.getcCount());
            item.setiNum(cart.getcNum());
            items.add(item);
        }

        //保存订单项
        sqlSession.getMapper(ItemDao.class).insertItems(items);

        //清空购物车
        cartService.clearCart(uid);

        sqlSession.commit();
        sqlSession.close();

        return orders;
    }

    @Override
    public List<Orders> findByUid(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Orders> ordersList = sqlSession.getMapper(OrderDao.class).findByUid(uid);
        sqlSession.close();
        return ordersList;
    }

    @Override
    public Orders findByOid(String oid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();

        //查询订单和地址
        Orders order = sqlSession.getMapper(OrderDao.class).findByOid(oid);

        //查询订单项
        List<Item> items = sqlSession.getMapper(ItemDao.class).findByOid(oid);

        //将订单项集合设置给订单对象
        order.setItems(items);

        sqlSession.close();

        return order;
    }

    @Override
    public void updateStatus(String oid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        sqlSession.getMapper(OrderDao.class).updateStatus(oid);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(String oid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();

        try {
            //删除订单项
            sqlSession.getMapper(ItemDao.class).deleteByOid(oid);

            //删除订单
            sqlSession.getMapper(OrderDao.class).delete(oid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void changeStatus(String oid, String status) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        sqlSession.getMapper(OrderDao.class).changeStatus(oid, status);
        sqlSession.commit();
        sqlSession.close();
    }


}
