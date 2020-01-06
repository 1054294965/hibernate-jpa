package com.example.accessingdatamysql.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


@Configuration
public class UserAuditor implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String ss="user2";
        return Optional.ofNullable(ss);
    }
}

