package com.gxl.dao;

import com.gxl.model.Item;

import java.util.List;

public interface ItemDao {
    void insertItems(List<Item> items);

    List<Item> findByOid(String oid);

    void deleteByOid(String oid);
}
