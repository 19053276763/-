package com.one.service;

import java.util.List;

import com.one.pojo.Dept;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept findById(Integer id);


    void update(Dept dept);

}
