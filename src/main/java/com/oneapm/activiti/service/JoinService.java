package com.oneapm.activiti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oneapm.activiti.test.domain.TblC;
import com.oneapm.activiti.test.mapper.TblAMapper;
import com.oneapm.activiti.test.mapper.TblBMapper;
import com.oneapm.activiti.test.mapper.TblCMapper;

@Service(value = "joinService")
public class JoinService {
    
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
    public void inserOneTblC() {
        TblC rc = new TblC();
        rc.setC1(count++);
        rc.setC2("c");
        tblCMapper.insertSelective(rc);
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
