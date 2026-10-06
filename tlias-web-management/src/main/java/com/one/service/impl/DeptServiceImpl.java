package com.one.service.impl;
import com.one.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.one.mapper.DeptMapper;
import com.one.pojo.Dept;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired 
    private DeptMapper  deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll() ;
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.findById(id);
    }
     @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }




}


