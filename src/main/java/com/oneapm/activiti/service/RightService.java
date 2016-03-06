package com.oneapm.activiti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public void inserOneTblB() {
        TblB rb = new TblB();
        rb.setB1(count++);
        rb.setB2("b");
        tblBMapper.insertSelective(rb);
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
