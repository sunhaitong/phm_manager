package com.chaos.manager.entity;

import lombok.Data;

/**
 * @author sunht
 * @date 2021/12/7
 */
@Data
public class QueryEntity {
    private Integer pageNum;
    private Integer pageSize;
    private String  devNo;
    private String pointNo;
}
