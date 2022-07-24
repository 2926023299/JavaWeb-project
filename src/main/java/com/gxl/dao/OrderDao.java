package com.gxl.dao;

import com.gxl.model.Item;
import com.gxl.model.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 插入订单
     * @param orders 订单对象
     */
    void insertOrders(Orders orders);

    List<Orders> findByUid(int id);

    Orders findByOid(String oid);

    void updateStatus(String oid);

    void delete(String oid);

    void changeStatus(@Param("oId") String oId, @Param("status") String status);
}
