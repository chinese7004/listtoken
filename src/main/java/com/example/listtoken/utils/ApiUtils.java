package com.example.listtoken.utils;

import com.example.listtoken.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Huoshan
 */
public class ApiUtils {
    private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

    private static final Pattern PATTERN_IS_NUMBER = Pattern.compile("[0-9]*");

    private static final Pattern PATTERN_IS_NUMBER_AND_CHAR = Pattern.compile("[0-9 a-z A-Z]*");

    public static final String USER = "user";

    private ApiUtils() {
    }

    public static boolean check(Object object) {
        if (object == null) {
            return false;
        }

        if (object instanceof String) {
            String str = (String) object;
            return !"".equals(str.trim());
        }

        return true;
    }

    public static User getUserInfo(HttpServletRequest request) {
        User user = null;
        if (request.getSession().getAttribute(USER) != null) {
            user = (User) request.getSession().getAttribute(USER);
        }
        return user;
    }

    /**
     * 判断字符串是否为数字
     */
    public static boolean isNumeric(String str) {
        Matcher isNum = PATTERN_IS_NUMBER.matcher(str);
        return isNum.matches();
    }

    /**
     * 检查字符串是不是只有数字和字符串
     */
    public static boolean isNumericAndChar(String str) {
        Matcher isNum = PATTERN_IS_NUMBER_AND_CHAR.matcher(str);
        return isNum.matches();
    }
}

