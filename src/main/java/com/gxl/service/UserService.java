package com.gxl.service;

import com.gxl.model.User;

/**
 * @author gxl
 */

public interface UserService {
    /**
     * @param username 用户名
     * @return true 存在 false 不存在
     */
    boolean checkedUser(String username);

    /**
     * @param user 用户对象
     * @return true 注册成功 false 注册失败
     */
    boolean registerUser(User user);

    int activateUser(String code);

    User loginUser(User user);
}
