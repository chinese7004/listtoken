package com.example.listtoken.dao;

import com.example.listtoken.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Huoshan
 */
@Repository
public interface UserAuthDao {
    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @Select({
            "SELECT id, username, password, nickname, email, phone",
            "FROM user",
            "WHERE username = #{username} AND delete_flag = 0"
    })
    User getUser(@Param("username") String username);
}
