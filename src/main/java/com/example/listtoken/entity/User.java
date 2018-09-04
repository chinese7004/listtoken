package com.example.listtoken.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Huoshan
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String phone;

    private Date createTime;

    private Date updateTime;

    private String operator;

    private Integer deleteFlag;
}
