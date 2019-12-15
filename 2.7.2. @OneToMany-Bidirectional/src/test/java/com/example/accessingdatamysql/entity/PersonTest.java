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
        Person person1 = new Person( "ABC-123" );
        Person person2 = new Person( "DEF-456" );

        Address address1 = new Address( "12th Avenue", "12A", "4005A" );
        Address address2 = new Address( "18th Avenue", "18B", "4007B" );

        entityManager.persist( person1 );
        entityManager.persist( person2 );

        entityManager.persist( address1 );
        entityManager.persist( address2 );

        person1.addAddress( address1 );
        person1.addAddress( address2 );

        person2.addAddress( address1 );

        entityManager.flush();


        person1.removeAddress( address1 );
    }
}