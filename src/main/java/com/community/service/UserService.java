package com.community.service;

import com.community.entity.User;

/**
 * @author 乐。
 */
public interface UserService {

    /**
     * @param token 判断用户状态的令牌
     * @return
     */
    User getUserByToken(String token);

    /**
     * 插入或更新用户
     * @param user
     */
    void insertOrUpdate(User user);
}
