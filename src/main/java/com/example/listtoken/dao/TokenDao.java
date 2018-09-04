package com.example.listtoken.dao;

import com.example.listtoken.entity.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
            "SELECT t.id, t.user_id userId, t.symbol, t.name, t.type, t.company_id companyId",
            "FROM token t",
            "WHERE t.delete_flag = 0",
            "LIMIT #{start}, #{pageNo}"
    })
    List<Token> getTokenList(@Param("start") Integer start, @Param("pageNo") Integer pageNo);

    /**
     * 查询加密货币
     * @param id
     * @return
     */
    @Select({
            "SELECT t.id, t.user_id userId, t.symbol, t.name, t.type, t.company_id companyId",
            "FROM token t",
            "WHERE t.id = #{id} AND t.delete_flag = 0",
    })
    Token getTokenById(@Param("id") Integer id);

    /**
     * 查询加密货币
     * @param symbol
     * @return
     */
    @Select({
            "SELECT t.id, t.user_id userId, t.symbol, t.name, t.type, t.company_id companyId",
            "FROM token t",
            "WHERE t.id = #{symbol} AND t.delete_flag = 0",
    })
    Token getTokenBySymbol(@Param("symbol") String symbol);

    /**
     * 新建加密货币
     * @param token
     * @param userId
     */
    @Insert({
            "INSERT INTO token",
            "(user_id, symbol, name, company_id, type)",
            "VALUES",
            "(#{userId}, #{token.symbol}, #{token.name}, #{token.companyId}, #{token.type})"
    })
    void create(@Param("token") Token token, @Param("userId") Integer userId);

    /**
     * 更新加密货币
     * @param token
     * @param userId
     */
    @Update({
            "UPDATE token",
            "SET user_id = #{userId}, symbol = #{token.symbol}, name = #{token.name}, company_id = #{token.companyId}, type = #{token.type}",
            "WHERE id = #{token.id}"
    })
    void update(@Param("token") Token token, @Param("userId") Integer userId);

    /**
     * 删除加密货币
     * @param id
     */
    @Update({
            "UPDATE token SET delete_flag = 1 WHERE id = #{id}"
    })
    void delete(Integer id);
}
