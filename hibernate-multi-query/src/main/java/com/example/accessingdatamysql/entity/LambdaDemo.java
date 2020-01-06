package com.example.accessingdatamysql.entity;

public class LambdaDemo {
    public static void main(String[] args) {
        MylambdaInterface s2=(s)-> System.out.println(s);

        s2.doSomeShit("1234");

    }
}
