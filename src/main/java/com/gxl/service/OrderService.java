package com.gxl.service;

import com.gxl.model.Orders;

import java.util.List;

public interface OrderService {
    Orders create(int uid, int aid, double total);

    List<Orders> findByUid(int uid);

    Orders findByOid(String oid); //根据订单号查询订单

    void updateStatus(String oid); //更新订单状态

    void delete(String oid);    //删除订单

    void changeStatus(String oid, String status);
}
