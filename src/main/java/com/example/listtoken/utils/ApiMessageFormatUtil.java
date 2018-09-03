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
    public static void formatJsonException(Map map, Exception e) {
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        map.put(ApiConstants.MESSAGE, e.getMessage());
    }

    public static void formatJsonException(JSONObject rstJson, Exception e) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        rstJson.put(ApiConstants.MESSAGE, e.getMessage());
    }

    /**
     * 格式化有data数据的json异常信息.
     *
     * @param e
     * @param map
     * @param data
     */
    public static void formatJsonExceptionWithData(Exception e, Map map, String data) {
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        map.put(ApiConstants.MESSAGE, e.getMessage());
        map.put(ApiConstants.DATA, data == null ? "" : data);
    }

    public static void formatJsonExceptionWithData(Exception e, JSONObject rstJson, String data) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        rstJson.put(ApiConstants.MESSAGE, e.getMessage());
        rstJson.put(ApiConstants.DATA, data == null ? "" : data);
    }

    /**
     * 格式化参数错误等非数据库异常信息.
     *
     * @param desc
     * @param map
     */
    public static void formatJsonError(String desc, Map map) {
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        map.put(ApiConstants.MESSAGE, desc == null ? "" : desc);
    }

    public static void formatJsonError(JSONObject rstJson, String desc) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        rstJson.put(ApiConstants.MESSAGE, desc == null ? "" : desc);
    }

    /**
     * 格式化有data(如：参数错误)的非数据库异常信息.
     *
     * @param desc
     * @param map
     * @param data
     */
    public static void formatJsonErrorWithData(String desc, Map map, String data) {
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        map.put(ApiConstants.MESSAGE, desc == null ? "" : desc);
        map.put(ApiConstants.DATA, data == null ? "" : data);
    }

    public static void formatJsonErrorWithData(String desc, JSONObject rstJson, String data) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_FAIL_0);
        rstJson.put(ApiConstants.MESSAGE, desc == null ? "" : desc);
        rstJson.put(ApiConstants.DATA, data == null ? "" : data);
    }

    /**
     * 格式化正常的有data数据的信息.
     *
     * @param map
     * @param obj
     */
    public static void formatJsonWithData(Map map, Object obj) {
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        map.put(ApiConstants.MESSAGE, ApiConstants.MESSAGE_SUCCESS);
        map.put(ApiConstants.DATA, obj == null ? "" : obj);
    }

    public static void formatJsonWithData(JSONObject rstJson, Object obj) {
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        rstJson.put(ApiConstants.MESSAGE, ApiConstants.MESSAGE_SUCCESS);
        rstJson.put(ApiConstants.DATA, obj == null ? "" : obj);
    }

    public static void formatJsonWithDataList(JSONObject rstJson, List dataList) {
        JSONObject data = new JSONObject();
        data.put(ApiConstants.DATA_LIST, dataList);
        rstJson.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        rstJson.put(ApiConstants.MESSAGE, ApiConstants.MESSAGE_SUCCESS);
        rstJson.put(ApiConstants.DATA, data);
    }

    public static void formatJsonWithDataList(Map map, List dataList) {
        Map data = new HashMap();
        data.put(ApiConstants.DATA_LIST, dataList);
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        map.put(ApiConstants.MESSAGE, ApiConstants.MESSAGE_SUCCESS);
        map.put(ApiConstants.DATA, data);
    }

    /**
     * 格式化正常的无data数据的信息.
     *
     * @param map
     */
    public static void formatJson(Map map) {
        map.put(ApiConstants.FLAG, ApiConstants.FLAG_SUCCESS);
        map.put(ApiConstants.MESSAGE, ApiConstants.MESSAGE_SUCCESS);
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
