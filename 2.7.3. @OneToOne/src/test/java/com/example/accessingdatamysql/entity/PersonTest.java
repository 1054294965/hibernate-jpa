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

        Phone phone = new Phone( "123-456-7890" );
        PhoneDetails details = new PhoneDetails( "T-Mobile", "GSM" );

        phone.addDetails( details );
        entityManager.persist( phone );
        entityManager.flush();
    }
    @Test
    @Transactional
    public void updatePerson(){
        Phone phone = entityManager.find(Phone.class, 42L);
        phone.setNumber("159");
        PhoneDetails details = phone.getDetails();
        details.setProvider("zhangfei");
        entityManager.persist(phone);
        entityManager.flush();
    }
    @Test
    @Transactional
    public void updateDetail(){
        PhoneDetails phoneDetails = entityManager.find(PhoneDetails.class, 43L);
        Phone phone = phoneDetails.getPhone();
        phone.setNumber("139");
        phoneDetails.setProvider("yidong");
        entityManager.persist(phoneDetails);
        entityManager.flush();
    }

    @Test
    @Transactional
    public void queryPhone(){
        Phone phone = entityManager.find(Phone.class, 42L);
        String s = JSON.toJSONString(phone);
        System.out.println(s);
    }

    @Test
    @Transactional
    public void queryDetail(){
        PhoneDetails phoneDetails = entityManager.find(PhoneDetails.class, 43L);
        String s = JSON.toJSONString(phoneDetails);
        System.out.println(s);
    }
    @Test
    @Transactional
    public void deletePhone(){
        Phone phone = entityManager.find(Phone.class, 42L);
        entityManager.remove(phone);
        entityManager.flush();
    }

    @Test
    @Transactional
    public void deleteDetail(){
        PhoneDetails phoneDetails = entityManager.find(PhoneDetails.class, 43L);
        entityManager.remove(phoneDetails);
        entityManager.flush();
    }
}