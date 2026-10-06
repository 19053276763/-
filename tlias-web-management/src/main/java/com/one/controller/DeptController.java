package com.one.controller;

import org.springframework.web.bind.annotation.RestController;

import com.one.pojo.Dept;
import com.one.pojo.Result;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.one.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/depts") // 统一路径前缀
public class DeptController {

    private final DeptService deptService;

    // 构造器注入，保证依赖不可变且便于单元测试
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 查询所有部门
     * GET /depts
     */
    @GetMapping
    public Result list() {
        log.info("查询所有部门信息");
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }
    /**
     * 删除部门
     * DELETE /depts?id=xx
     */
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除部门信息: {}", id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 新增部门
     * POST /depts
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门信息: {}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门信息
     * GET /depts/{id}
     */
    @GetMapping("/{id}")
    public Result getinfo(@PathVariable Integer id) {
        log.info("根据id查询部门信息: {}", id);
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门信息: {}", dept);
        deptService.update(dept);
        return Result.success();
    }
    

}
