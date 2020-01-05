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
        Person person = new Person("zhangfei");
        entityManager.persist( person );

        Phone phone = new Phone("123-456-7890");
        phone.setPerson( person );
        entityManager.persist( phone );
        entityManager.flush();
    }
    @Test
    @Transactional
    public void insertPerson(){
        Person guanyu = new Person("guanyu");
        guanyu.setPhoneList(null);
        entityManager.persist( guanyu );
        entityManager.flush();
    }
    @Test
    @Transactional
    public void insertPhone(){
        Phone phone = new Phone("181");
        Person person = new Person();
        person.setId(44L);
        phone.setPerson(person);
        entityManager.persist( phone );
        entityManager.flush();
    }


    @Test
    @Transactional
    public void queryPerson(){
        Person person = entityManager.find(Person.class, 44L);
        System.out.println(JSON.toJSONString(person));
    }
    @Test
    @Transactional
    public void queryPhone(){
        Phone phone = entityManager.find(Phone.class, 45L);
        System.out.println(JSON.toJSONString(phone));
    }
    @Test
    @Transactional
    public void updatePerson(){
        Person person = entityManager.find(Person.class, 44L);
        Phone phone = new Phone("139");
        person.addPhone(phone);
        entityManager.persist(person);
        entityManager.flush();
    }
    @Test
    @Transactional
    public void updatePhone(){
        Phone phone = entityManager.find(Phone.class, 45L);
        phone.setNumber("159");
        entityManager.persist(phone);
        entityManager.flush();
    }
    @Test
    @Transactional
    public void deletePhone(){
        Phone phone = entityManager.find(Phone.class, 48L);
        entityManager.remove(phone);
        entityManager.flush();
    }
    @Test
    @Transactional
    public void deletePerson(){
        Person person = entityManager.find(Person.class, 44L);
        entityManager.remove(person);
        entityManager.flush();
    }
}