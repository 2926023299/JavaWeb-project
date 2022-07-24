package com.gxl.dao;

import com.gxl.model.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypeDao {
    List<Type> findAll();
}
