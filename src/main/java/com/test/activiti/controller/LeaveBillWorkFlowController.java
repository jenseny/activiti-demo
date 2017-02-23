package com.test.activiti.controller;

import com.test.activiti.exceptions.ApplicationException;
import com.test.activiti.service.LeaveBillWorkFlowService;
import com.test.activiti.util.ConstantUtil;
import com.test.activiti.util.JsonUtil;
import com.test.activiti.util.ResponseJsonResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by riven on 2/23/17.
 */
@Controller
public class LeaveBillWorkFlowController {

    private final static Logger logger = Logger.getLogger(LeaveBillWorkFlowController.class);

    @Autowired
    private LeaveBillWorkFlowService leaveBillWorkFlowService;

    @RequestMapping(value = "toDeployment",method = RequestMethod.GET)
    public String toDeployment(){
        return "module/deployment";
    }

    @RequestMapping(value = "/deployment",method = RequestMethod.POST)
    public void uploadProcess(MultipartFile file,String name,HttpServletResponse response){
        ResponseJsonResult result = new ResponseJsonResult();
        try {
            if(file==null){
                throw new ApplicationException("参数错误");
            }
            if(StringUtils.isBlank(name)){
                throw new ApplicationException("参数错误");
            }
            leaveBillWorkFlowService.uploadProcessFill(file.getInputStream(),name);
            result.setCode(ConstantUtil.SUCCESS);
            result.setMessage("success");
        } catch (IOException e) {
            result.setCode(ConstantUtil.FAIL);
            result.setMessage("文件上传出错");
            e.printStackTrace();
        }catch (ApplicationException e) {
            result.setCode(ConstantUtil.FAIL);
            result.setMessage("参数错误");
            e.printStackTrace();
        }catch (Exception e) {
            result.setCode(ConstantUtil.FAIL);
            result.setMessage("系统错误");
            e.printStackTrace();
        }
        JsonUtil.renderJSON(response,result);
    }
}
