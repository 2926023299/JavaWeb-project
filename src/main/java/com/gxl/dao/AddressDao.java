package com.gxl.dao;

import com.gxl.model.Address;

import java.util.List;

public interface AddressDao {
    List<Address> findByUid(int uid);

    void addAddress(Address address);

    void delete(int aid);

    void setDefault(int aId);

    void setNoDefault(int uid);

    void update(Address address);
}
