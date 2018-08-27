package com.example.listtoken.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.listtoken.entity.Token;
import com.example.listtoken.service.TokenService;
import com.example.listtoken.utils.ApiMessageFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Huoshan
 */
@RestController
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @RequestMapping("/getTokenList")
    public JSONObject getTokenList(@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "pageNo",required = false, defaultValue = "1") Integer pageNo) {
        JSONObject resJson = new JSONObject();

        List<Token> tokenList = null;
        try {
            tokenList = tokenService.getTokenList(pageSize, pageNo);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
        }

        ApiMessageFormatUtil.formatJsonWithDataList(resJson, tokenList);
        return resJson;
    }
}
