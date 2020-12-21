package com.lidadaibiao.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)  //支持链式写法
public class Dept implements Serializable {//Dept 实体类 orm 类表关系映射
    private long deptno;//主键
    private String dname;
    //这个数据库存在那个数据库的字段~ 微服务  一个服务对应一个数据库 可能存在不同的数据库
    private String dsource;
    public Dept(String dname){
        this.dname = dname;
    }


}
