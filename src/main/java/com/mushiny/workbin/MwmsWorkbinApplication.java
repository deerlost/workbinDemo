package com.mushiny.workbin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.mushiny.workbin.dao"})
public class MwmsWorkbinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MwmsWorkbinApplication.class, args);
    }

}
