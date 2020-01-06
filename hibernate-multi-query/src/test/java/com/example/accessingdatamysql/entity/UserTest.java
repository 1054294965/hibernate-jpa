package com.example.accessingdatamysql.entity;



import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)  // 用什么来运行测试，例如可以用Junit4.Class
@SpringBootTest  // 替代ContextConfiguration来指定上下文
public class UserTest {
    @Autowired
    private EntityManager entityManager;
    @Test
    @Transactional
    public void insert(){  // 插入的时候 2个时间都一样，创建者和更新者也一样
        User user = new User();
        user.setAddress("zhongshanlu");
        user.setMobile("159");
        user.setUsername("zhangfei");
        user.setPassword("1234");
        entityManager.persist(user);
        entityManager.flush();

    }
    @Test
    @Transactional
    public void update(){   // 更新，updateDate 和 updateBy是否变化
        User user = entityManager.find(User.class, 1l);
        user.setDelFlag("1");
        entityManager.merge(user);
        entityManager.flush();
    }
}