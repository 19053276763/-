package com.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.one.pojo.Emp;
import com.one.pojo.PageResult;
import com.one.pojo.Result;
import com.one.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestController 
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService ;
    @GetMapping
    //默认值是1，10
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询员工信息: page={}, pageSize={}", page, pageSize);
        PageResult<Emp> pageResult = empService.Page(page, pageSize);
        return Result.success(pageResult);
    }
}
