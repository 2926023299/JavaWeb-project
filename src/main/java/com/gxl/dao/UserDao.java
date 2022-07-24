package com.gxl.dao;

import com.gxl.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    @Select("select * from user where username = #{username}")
    User selectUserByUsername(String username);

    /**
     * 注册用户
     * @param user 用户
     * @return 注册成功返回1，否则返回0
     */
    @Insert("insert into user(username, password, sex, email, code, status, role) values(#{username}, #{password},#{sex}, #{email}, #{code}, #{status}, #{role})")
    int registerUser(User user);

    /**
     * 根据激活码获取对象
     * @param code 激活码
     * @return 有此激活码返回对象
     */
    @Select("select * from user where code = #{code}")
    User selectUserByCode(String code);

    /**
     * 根据用户id激活用户
     * @param id 用户id
     * @param status 状态
     * @return 激活成功返回1，否则返回0
     */
    @Update("update user set status = #{status} where id = #{id}")
    int UpdateStatus(@Param("id") int id, @Param("status") int status);

    /**
     * 登录验证
     * @param user 用户对象
     * @return 登录成功返回用户对象，否则返回null
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User LoginUser(User user);
}
