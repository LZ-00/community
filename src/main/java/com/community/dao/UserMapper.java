package com.community.dao;

import com.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 乐。
 */
@Mapper
public interface UserMapper {

    /**
     * 插入user
     * @param user
     * @return
     */
    void insert(User user);

    /**
     * 根据令牌获取User
     * @param token
     * @return
     */
    User getUserByToken(@Param(value = "token") String token);

    /**
     * 根据userId查询user
     * @param accountId
     * @return
     */
    User getUserByAccountId(@Param("accountId") String accountId);

    /**
     * 更新user
     * @param user
     */
    void update(User user);
}
