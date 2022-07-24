package com.gxl.service.impl;

import com.gxl.dao.UserDao;
import com.gxl.model.User;
import com.gxl.service.UserService;
import com.gxl.utils.Constants;
import com.gxl.utils.MD5Utils;
import com.gxl.utils.MybatisTool;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public boolean checkedUser(String username) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);

        User user = sqlSession.getMapper(UserDao.class).selectUserByUsername(username);

        sqlSession.close();

        return user != null;
    }

    @Override
    public boolean registerUser(User user) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);
        boolean b = sqlSession.getMapper(UserDao.class).registerUser(user) > 0;

        sqlSession.close();

        return b;
    }

    @Override
    public int activateUser(String code) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);
        //根据激活码获取对象
        User user = sqlSession.getMapper(UserDao.class).selectUserByCode(code);
        if (user == null) {
            return 0;
        }

        //判断用户是否已经激活
        if (user.getStatus() == Constants.USER_ACTIVE) {
            return 2;
        }

        //根据对象id激活用户
        int i = sqlSession.getMapper(UserDao.class).UpdateStatus(user.getId(), Constants.USER_ACTIVE);

        sqlSession.close();

        return i;
    }

    @Override
    public User loginUser(User user) {
        SqlSession sqlSession = MybatisTool.getSqlSession(true);
        User user1 = sqlSession.getMapper(UserDao.class).LoginUser(user);

        sqlSession.close();

        return user1;
    }

}
