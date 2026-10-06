package com.one.service;

import com.one.pojo.Emp;
import com.one.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> Page(Integer page, Integer pageSize);
    
}
