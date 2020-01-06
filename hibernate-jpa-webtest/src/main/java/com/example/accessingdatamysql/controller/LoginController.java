package com.example.accessingdatamysql.controller;

import com.alibaba.fastjson.JSON;
//import com.example.accessingdatamysql.Example;
import com.example.accessingdatamysql.entity.User;
import com.example.accessingdatamysql.web.CacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.Set;


@RestController
@RequestMapping("")
@Slf4j
public class LoginController {
    @Autowired
    private CacheServiceImpl cacheService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        int cache1 = cacheService.get();
        System.out.println(cache1);
        System.out.println(cacheService.get2());
        ddd();
        return "fail";
    }
    @RequestMapping("/put")
    public String put(HttpServletRequest request){
        cacheService.put();
        return "fail";
    }
    @RequestMapping("/evict")
    public String evict(HttpServletRequest request){
        cacheService.evict();
        return "fail";
    }
    public void ddd(){
        log.info("报错了");
    }
}
