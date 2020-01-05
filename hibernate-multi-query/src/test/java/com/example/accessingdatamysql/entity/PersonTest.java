package com.example.accessingdatamysql.entity;



import com.alibaba.fastjson.JSON;
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
    public void insert(){
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
//        person1.removeAddress( address1 );
    }
    @Test
    @Transactional
    public void queryPerson(){
        Person person = entityManager.find(Person.class, 1L);
        System.out.println(JSON.toJSONString(person));
    }
    @Test
    @Transactional
    public void queryAddress(){
        Address address = entityManager.find(Address.class, 2L);
        System.out.println(JSON.toJSONString(address));
    }
    @Test
    @Transactional
    public void personDeleteAddress(){
        Person person = entityManager.find(Person.class, 1L);
        Address address = entityManager.find(Address.class, 3L);
        person.removeAddress(address);
        entityManager.persist(person);
        entityManager.flush();
    }
    @Test
    @Transactional
    public void deletePerson(){
        Person person = entityManager.find(Person.class, 4L);
//        Address address = entityManager.find(Address.class, 2L);
//        person.removeAddress(address);
        entityManager.remove(person);
        entityManager.flush();
    }
    @Test
    @Transactional
    public void deleteAddress(){
        Address address = entityManager.find(Address.class, 2L);
        entityManager.remove(address);
        entityManager.flush();
    }
}