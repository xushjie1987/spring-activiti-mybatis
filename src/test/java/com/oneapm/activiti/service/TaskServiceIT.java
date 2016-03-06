package com.oneapm.activiti.service;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oneapm.activiti.ITContext;

public class TaskServiceIT extends ITContext {
    
    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private RuntimeService    runtimeService;
    
    @Autowired
    private TaskService       taskService;
    
    @Autowired
    private HistoryService    historyService;
    
    @Autowired
    private ManagementService managementService;
    
    /**
     * 普通的顺序流程
     */
    @Test
    public void case_01() {
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
    }
    
    /**
     * 定时timer的job，不需要手动触发
     */
    @Test
    public void case_02() {
        try {
            Thread.currentThread().join();
        } catch (InterruptedException ingore) {
            // skip
        }
    }
    
}
