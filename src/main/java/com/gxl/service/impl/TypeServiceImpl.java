package com.gxl.service.impl;

import com.gxl.dao.TypeDao;
import com.gxl.model.Type;
import com.gxl.service.TypeService;
import com.gxl.utils.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    @Override
    public List<Type> findAll() {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);

        List<Type> all = sqlSession.getMapper(TypeDao.class).findAll();

        sqlSession.close();

        return all;
    }
}
