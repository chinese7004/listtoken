package com.example.listtoken.dao;

import com.example.listtoken.entity.Token;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huoshan
 */
@Repository
public interface TokenDao {
    /**
     * 获取加密货币列表
     * @param start
     * @param pageNo
     * @return
     */
    @Select({
            "SELECT t.id, t.user_id userId, t.symbol, t.name, t.type, c.name companyName, c.website",
            "FROM token t",
            "LEFT JOIN company c ON t.company_id = c.id",
            "WHERE t.delete_flag = 0 AND c.delete_flag = 0",
            "LIMIT #{start}, #{pageNo}"
    })
    List<Token> getTokenList(@Param("start") Integer start, @Param("pageNo") Integer pageNo);
}
