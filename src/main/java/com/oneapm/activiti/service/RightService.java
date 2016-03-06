package com.oneapm.activiti.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oneapm.activiti.test.domain.TblB;
import com.oneapm.activiti.test.mapper.TblAMapper;
import com.oneapm.activiti.test.mapper.TblBMapper;
import com.oneapm.activiti.test.mapper.TblCMapper;

@Service(value = "rightService")
public class RightService {
    
    @Autowired
    private TblAMapper tblAMapper;
    
    @Autowired
    private TblBMapper tblBMapper;
    
    @Autowired
    private TblCMapper tblCMapper;
    
    private Integer    count = 1;
    
    /**
     * 
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void inserOneTblB() {
        TblB rb = new TblB();
        rb.setB1(count++);
        rb.setB2("b");
        tblBMapper.insertSelective(rb);
    }
    
    /**
     * 
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void forkRight() {
        Date start = new Date();
        TblB rb = new TblB();
        rb.setB1(count * 20);
        rb.setB2("b");
        tblBMapper.insertSelective(rb);
        try {
            Thread.sleep(5000);
            System.out.println(start + " - " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }
    
    /**
     * @param count
     *            the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }
    
}
