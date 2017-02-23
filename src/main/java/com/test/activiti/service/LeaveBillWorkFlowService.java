package com.test.activiti.service;

import java.io.InputStream;

/**
 * Created by riven on 2/23/17.
 */
public interface LeaveBillWorkFlowService {

    /**
     * 上传流程文件
     * @param inputStream
     * @param name
     */
    void uploadProcessFill(InputStream inputStream,String name);
}
