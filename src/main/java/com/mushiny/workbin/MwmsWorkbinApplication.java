package com.mushiny.workbin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.mushiny.workbin.dao"})
@EnableScheduling
public class MwmsWorkbinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MwmsWorkbinApplication.class, args);
    }

}
