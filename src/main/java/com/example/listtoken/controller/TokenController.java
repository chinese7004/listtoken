package com.example.listtoken.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.listtoken.entity.Token;
import com.example.listtoken.service.TokenService;
import com.example.listtoken.utils.ApiMessageFormatUtil;
import com.example.listtoken.utils.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author Huoshan
 */
@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @RequestMapping("/list")
    public JSONObject getTokenList(@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "pageNo",required = false, defaultValue = "1") Integer pageNo) {
        JSONObject resJson = new JSONObject();

        List<Token> tokenList;
        try {
            tokenList = tokenService.getTokenList(pageSize, pageNo);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJsonWithData(resJson, tokenList);
        return resJson;
    }

    @RequestMapping("/create")
    public JSONObject createToken(@RequestBody Token token, HttpServletRequest request) {
        JSONObject resJson = new JSONObject();

        Integer userId = ApiUtils.getUserInfo(request).getId();
        try {
            tokenService.create(token, userId);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

    @RequestMapping("/update")
    public JSONObject updateToken(@RequestBody Token token, HttpServletRequest request) {
        JSONObject resJson = new JSONObject();

        Integer userId = ApiUtils.getUserInfo(request).getId();
        try {
            tokenService.update(token, userId);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

    @RequestMapping("/delete")
    public JSONObject deleteToken(@RequestParam Integer id) {
        JSONObject resJson = new JSONObject();

        try {
            tokenService.delete(id);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

    @RequestMapping("/get")
    public JSONObject getToken(@RequestParam Integer id) {
        JSONObject resJson = new JSONObject();

        Token token;
        try {
            token = tokenService.get(id);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJsonWithData(resJson, token);
        return resJson;
    }
}
