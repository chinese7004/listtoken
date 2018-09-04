package com.example.listtoken.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.listtoken.constants.ApiConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 格式化json数据异常信息
 * @author Huoshan
 */
public class ApiMessageFormatUtil {

    public static void formatJsonException(JSONObject rstJson, Exception e) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        rstJson.put(ApiConstants.MESSAGE, e.getMessage());
    }


    public static void formatJsonError(JSONObject rstJson, String desc) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        rstJson.put(ApiConstants.MESSAGE, desc == null ? "" : desc);
    }

    public static void formatJsonWithData(JSONObject rstJson, Object obj) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        rstJson.put(ApiConstants.MESSAGE, ApiConstants.MESSAGE_SUCCESS);
        rstJson.put(ApiConstants.DATA, obj == null ? "" : obj);
    }

    /**
     * 格式化正常的无data数据的信息.
     * @param jsonObject
     */
    public static void formatJson(JSONObject jsonObject) {
        jsonObject.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        jsonObject.put(ApiConstants.MESSAGE, ApiConstants.MESSAGE_SUCCESS);
    }
}
