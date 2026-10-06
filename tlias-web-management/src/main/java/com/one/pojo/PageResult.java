package com.one.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PageResult
 */
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class PageResult<T> {

    private Long total;
    private List<T> rows;  // 字段名与前端的 data.rows 对应

}
