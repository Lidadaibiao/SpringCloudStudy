package com.lidadaibiao.springcloud.dao;

import com.lidadaibiao.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    Boolean addDept(Dept dept);
    Dept queryByDno(long deptno);
    List<Dept> queryAll();
}
