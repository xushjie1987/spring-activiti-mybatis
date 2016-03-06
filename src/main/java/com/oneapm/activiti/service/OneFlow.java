package com.oneapm.activiti.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class OneFlow implements JavaDelegate {
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Hello One Flow: " + execution.getParentId());
    }
    
}
