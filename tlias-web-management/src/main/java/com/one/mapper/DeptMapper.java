package com.one.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.one.pojo.Dept;
@Mapper 
public interface DeptMapper {

@Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> findAll();

 @Delete("delete from dept where id = #{id}")
 void deleteById(Integer id);

 // 注意：若 JSON 传入 id，将使用该 id 插入（需确保不与已有主键冲突）；不传则走数据库自增
 @Insert ("insert into dept (id,name,create_time,update_time) values (#{id},#{name},#{createTime},#{updateTime})")
 void insert(Dept dept);

 @Select("select id,name,create_time,update_time from dept where id = #{id}")
 Dept findById(Integer id);

 @Update ("update dept set name=#{name},update_time=#{updateTime} where id = #{id}")
 void update(Dept dept);


}
