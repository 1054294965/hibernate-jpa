package com.example.accessingdatamysql.entity;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)  // 用什么来运行测试，例如可以用Junit4.Class
@SpringBootTest  // 替代ContextConfiguration来指定上下文
public class PersonTest {

    @Autowired
    private EntityManager entityManager;
    @Test
    @Transactional
    public void t1(){

        Phone phone = new Phone( "123-456-7890" );
        PhoneDetails details = new PhoneDetails( "T-Mobile", "GSM" );

        phone.addDetails( details );
        entityManager.persist( phone );
        entityManager.flush();
    }

}