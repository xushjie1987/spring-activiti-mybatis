package com.oneapm.activiti.service;

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
