package com.lidadaibiao.springcloud.service;

import com.lidadaibiao.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//降级
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(long id) {
                return new Dept().setDeptno(id)
                        .setDname("id=>"+id+"，不存在该用户，或者信息无法找到")
                        .setDsource("no this database in mysql");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }
        };
    }
}
