package com.gxl.service;

import com.gxl.model.PageBean;
import com.gxl.model.Product;

public interface ProductService {
    PageBean<Product> findByPage(int page, int pageSize, int tid);

    Product findByPid(int pid);
}
