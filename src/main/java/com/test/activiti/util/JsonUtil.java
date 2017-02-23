package com.test.activiti.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by riven on 2/23/17.
 */
public class JsonUtil {

    public static void renderJSON(HttpServletResponse response, Object object) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(JSONObject.toJSONString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
