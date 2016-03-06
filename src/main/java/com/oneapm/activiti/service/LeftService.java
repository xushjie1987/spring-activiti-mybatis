package com.oneapm.activiti.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oneapm.activiti.test.domain.TblA;
import com.oneapm.activiti.test.mapper.TblAMapper;
import com.oneapm.activiti.test.mapper.TblBMapper;
import com.oneapm.activiti.test.mapper.TblCMapper;

@Service(value = "leftService")
public class LeftService {
    
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
    public void inserOneTblA() {
        TblA ra = new TblA();
        ra.setA1(count++);
        ra.setA2("a");
        tblAMapper.insertSelective(ra);
    }
    
    /**
     * 
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void loopInsertTblA() {
        TblA ra = new TblA();
        ra.setA1(count++);
        ra.setA2("a");
        tblAMapper.insertSelective(ra);
    }
    
    /**
     * 
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void forkLeft() {
        Date start = new Date();
        TblA ra = new TblA();
        ra.setA1(count + 10000);
        ra.setA2("a");
        tblAMapper.insertSelective(ra);
        try {
            Thread.sleep(3000);
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
