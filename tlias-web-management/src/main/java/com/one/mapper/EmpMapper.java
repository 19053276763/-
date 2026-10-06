package com.one.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.one.pojo.Emp;

@Mapper 
public interface EmpMapper {

    //查询员工数据（不写 limit，分页由 PageHelper 插件自动追加）
    @Select("select e.id, e.username, e.name, e.gender, e.phone, e.job, e.salary, e.image, " +
            "e.entry_date, e.dept_id, d.name deptName, e.create_time, e.update_time " +
            "from emp e left join dept d on e.dept_id = d.id " +
            "order by e.update_time desc")
    public List<Emp> list();

}
