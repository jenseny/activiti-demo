package com.test.activiti.controller;

import com.test.activiti.exceptions.ApplicationException;
import com.test.activiti.util.ConstantUtil;
import com.test.activiti.util.ResponseJsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by riven on 2/22/17.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {""},method = RequestMethod.GET)
    public String toLogin(){
        return "login/login";
    }

    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    @ResponseBody
    public ResponseJsonResult login(String name, HttpServletRequest request){
        ResponseJsonResult result = new ResponseJsonResult();
        try {
            if(StringUtils.isBlank(name)){
                throw new ApplicationException("参数错误");
            }
            request.getSession().setAttribute(ConstantUtil.CURRENT_USER,name);
            result.setCode(ConstantUtil.SUCCESS);
            result.setMessage("login success");
        } catch (ApplicationException e) {
            e.printStackTrace();
            result.setCode(ConstantUtil.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = {"/index"},method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        return "index";
    }

}
