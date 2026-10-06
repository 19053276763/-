package com.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.one.mapper.EmpMapper;
import com.one.pojo.Emp;
import com.one.pojo.PageResult;
import com.one.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> Page(Integer page, Integer pageSize) {
        // 设置分页参数：紧跟其后的第一条查询会被自动改写为分页 SQL，并自动发送 count 语句
        PageHelper.startPage(page, pageSize);
        List<Emp> emps = empMapper.list();
        try (// Page 继承自 ArrayList，携带 total 等分页信息
        Page<Emp> page1 = (Page<Emp>) emps) {
            return new PageResult<>(page1.getTotal(), emps);
        }
    }

}
