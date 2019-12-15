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

        Person person1 = new Person();
        Person person2 = new Person();

        Address address1 = new Address( "12th Avenue", "12A" );
        Address address2 = new Address( "18th Avenue", "18B" );

        person1.getAddresses().add( address1 );
        person1.getAddresses().add( address2 );

        person2.getAddresses().add( address1 );

        entityManager.persist( person1 );
        entityManager.persist( person2 );

        entityManager.flush();

        person1.getAddresses().remove( address1 );

    }

}