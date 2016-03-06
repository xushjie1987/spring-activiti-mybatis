package com.oneapm.activiti.service;

import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;

public class TwoFlow implements ActivityBehavior {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2049572347472480432L;
    
    @Override
    public void execute(ActivityExecution execution) throws Exception {
        System.out.println("Hello Two Flow: " + execution.getParentId());
    }
    
}
