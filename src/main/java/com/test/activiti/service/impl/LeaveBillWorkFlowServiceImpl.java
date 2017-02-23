package com.test.activiti.service.impl;

import com.test.activiti.service.LeaveBillWorkFlowService;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * Created by riven on 2/23/17.
 */
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service
public class LeaveBillWorkFlowServiceImpl implements LeaveBillWorkFlowService {

    @Autowired
    private RepositoryService repositoryService;

    public void uploadProcessFill(InputStream inputStream, String name) {
        repositoryService.createDeployment()
                .name(name).addZipInputStream(new ZipInputStream(inputStream))
                .deploy();

    }
}
