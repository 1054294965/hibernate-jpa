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
        Person person = new Person();
        Phone phone1 = new Phone( "123-456-7890" );
        Phone phone2 = new Phone( "321-654-0987" );

        person.getPhones().add( phone1 );
        person.getPhones().add( phone2 );
        entityManager.persist( person );
        entityManager.flush();

        person.getPhones().remove( phone1 );
    }
}