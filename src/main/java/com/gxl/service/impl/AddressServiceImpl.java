package com.gxl.service.impl;

import com.gxl.dao.AddressDao;
import com.gxl.model.Address;
import com.gxl.service.AddressService;
import com.gxl.utils.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    @Override
    public List<Address> findByUid(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        AddressDao mapper = sqlSession.getMapper(AddressDao.class);

        List<Address> list = mapper.findByUid(uid);

        sqlSession.close();

        return list;
    }

    @Override
    public void addAddress(Address address) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        AddressDao mapper = sqlSession.getMapper(AddressDao.class);

        mapper.addAddress(address);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(int aid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        AddressDao mapper = sqlSession.getMapper(AddressDao.class);

        mapper.delete(aid);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void setDefault(int aid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        AddressDao mapper = sqlSession.getMapper(AddressDao.class);

        mapper.setDefault(aid);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void setNoDefault(int uid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        AddressDao mapper = sqlSession.getMapper(AddressDao.class);

        mapper.setNoDefault(uid);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Address address) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        AddressDao mapper = sqlSession.getMapper(AddressDao.class);

        mapper.update(address);

        sqlSession.commit();
        sqlSession.close();
    }
}

