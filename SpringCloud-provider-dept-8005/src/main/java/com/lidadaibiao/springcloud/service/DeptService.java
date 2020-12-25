package com.lidadaibiao.springcloud.service;

import com.lidadaibiao.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    Boolean addDept(Dept dept);
    Dept queryByDno(long deptno);
    List<Dept> queryAll();
}
