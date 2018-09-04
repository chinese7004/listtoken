package com.example.listtoken.dao;

import com.example.listtoken.entity.Company;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huoshan
 */
@Repository
public interface CompanyDao {
    /**
     * 获取公司列表
     * @param start
     * @param pageNo
     * @return
     */
    @Select({
            "SELECT id, name, website",
            "FROM company c",
            "WHERE delete_flag = 0",
            "LIMIT #{start}, #{pageNo}"
    })
    List<Company> getCompanyList(@Param("start") Integer start, @Param("pageNo") Integer pageNo);

    /**
     * 查询公司
     * @param id
     * @return
     */
    @Select({
            "SELECT id, name, website",
            "FROM company",
            "WHERE id = #{id} AND delete_flag = 0",
    })
    Company getCompanyById(@Param("id") Integer id);

    /**
     * 查询公司
     * @param name
     * @return
     */
    @Select({
            "SELECT id, name, website",
            "FROM company",
            "WHERE name = #{name} AND delete_flag = 0",
    })
    Company getCompanyByName(@Param("name") String name);

    /**
     * 新建公司
     * @param company
     * @return
     */
    @Insert({
            "INSERT INTO token",
            "(name, website)",
            "VALUES",
            "(#{company.name}, #{company.website})"
    })
    void createCompany(@Param("company") Company company);

    /**
     * 建立用户-公司关联关系
     * @param companyId
     * @param userId
     */
    @Insert({
            "INSERT INTO user_company_rel",
            "(user_id, company_id)",
            "VALUES",
            "(#{userId}, #{companyId})"
    })
    void createCompanyUserRel(@Param("companyId") Integer companyId, @Param("userId") Integer userId);

    /**
     * 更新公司
     * @param company
     */
    @Update({
            "UPDATE token",
            "SET name = #{company.name}, website = #{company.website}",
            "WHERE id = #{token.id}"
    })
    void update(@Param("company") Company company);

    /**
     * 删除公司
     * @param id
     */
    @Update({
            "UPDATE company SET delete_flag = 1 WHERE id = #{id}"
    })
    void delete(@Param("id") Integer id);
}
