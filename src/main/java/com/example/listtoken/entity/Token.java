package com.example.listtoken.entity;

import lombok.Data;

/**
 * @author Huoshan
 */
@Data
public class Token {
    private Integer id;

    private Integer userId;

    private String symbol;

    private String name;

    private Integer companyId;

    private String type;
}
