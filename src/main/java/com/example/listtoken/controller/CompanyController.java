package com.example.listtoken.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.listtoken.entity.Company;
import com.example.listtoken.service.CompanyService;
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
 * @author Huoshan
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/list")
    public JSONObject getCompanyList(@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "pageNo",required = false, defaultValue = "1") Integer pageNo) {
        JSONObject resJson = new JSONObject();

        List<Company> companyList;
        try {
            companyList = companyService.getCompanyList(pageSize, pageNo);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJsonWithData(resJson, companyList);
        return resJson;
    }

    @RequestMapping("/create")
    public JSONObject createCompany(@RequestBody Company company, HttpServletRequest request) {
        JSONObject resJson = new JSONObject();

        Integer userId = ApiUtils.getUserInfo(request).getId();
        try {
            companyService.create(company, userId);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

    @RequestMapping("/update")
    public JSONObject updateCompany(@RequestBody Company company, HttpServletRequest request) {
        JSONObject resJson = new JSONObject();

        Integer userId = ApiUtils.getUserInfo(request).getId();
        try {
            companyService.update(company, userId);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

    @RequestMapping("/delete")
    public JSONObject deleteCompany(@RequestParam Integer id) {
        JSONObject resJson = new JSONObject();

        try {
            companyService.delete(id);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJson(resJson);
        return resJson;
    }

    @RequestMapping("/get")
    public JSONObject getCompany(@RequestParam Integer id) {
        JSONObject resJson = new JSONObject();

        Company company;
        try {
            company = companyService.get(id);
        } catch (Exception e) {
            ApiMessageFormatUtil.formatJsonException(resJson, e);
            return resJson;
        }

        ApiMessageFormatUtil.formatJsonWithData(resJson, company);
        return resJson;
    }
}
