package com.gxl.service;

import com.gxl.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> findByUid(int uid);

    void addAddress(Address address);

    void delete(int aid);

    void setDefault(int aid);

    void setNoDefault(int uid);

    void update(Address address);
}
