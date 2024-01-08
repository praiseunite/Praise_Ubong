package com.davacom.thymeleafappjdbc;

import com.davacom.thymeleafappjdbc.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ThymeleafAppJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafAppJdbcApplication.class, args);
//
//
//        User u = new User();
//        u.setEmail("d@g.com");
//        u.setId(23L);
//        u.setPassword("1234");
//
//
//
//        User u2 = User.builder()
//                .id(43l)
//                .email("FFF@HJHDK")
//                .password("23456")
//                .build();
//
//
//        log.info(u.toString());
//        log.info(u2.toString());
    }

}
