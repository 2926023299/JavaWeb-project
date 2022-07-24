package com.gxl.dao;

import com.gxl.model.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    List<Product> selectCountByTid(int tid);

    List<Product> SelectProductByPage(@Param("page") int page, @Param("pageSize") int pageSize, @Param("tid") int tid);

    Product findByPid(int pid);
}
