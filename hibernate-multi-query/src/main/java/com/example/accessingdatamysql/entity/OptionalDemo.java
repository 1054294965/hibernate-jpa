package com.example.accessingdatamysql.entity;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        Optional<Object> optional = Optional.ofNullable(0);
        Optional.empty();
        System.out.println(optional.isPresent());
        Optional<Object> o = Optional.empty();;
        System.out.println(o.isPresent());

    }


}
