package com.gxl.service.impl;

import com.gxl.dao.ProductDao;
import com.gxl.model.PageBean;
import com.gxl.model.Product;
import com.gxl.service.ProductService;
import com.gxl.utils.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public PageBean<Product> findByPage(int page, int pageSize, int tid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();
        List<Product> listCount = sqlSession.getMapper(ProductDao.class).selectCountByTid(tid); //查询总条数

        int count = listCount.size();

        List<Product> list = sqlSession.getMapper(ProductDao.class)
                .SelectProductByPage((page - 1) * pageSize, pageSize, tid); //查询当前页数据); //查询当前页数据

        sqlSession.close();
        return new PageBean<Product>(list, pageSize, page, count);
    }

    @Override
    public Product findByPid(int pid) {
        SqlSession sqlSession = MybatisTool.getSqlSession();

        Product product = sqlSession.getMapper(ProductDao.class).findByPid(pid);

        sqlSession.close();
        return product;
    }
}
