package com.mushiny.workbin;

import com.mushiny.workbin.config.dataSource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.mushiny.workbin.dao"})
@EnableScheduling
@Import({DynamicDataSourceRegister.class})
@EnableAspectJAutoProxy(exposeProxy = true)
public class MwmsWorkbinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MwmsWorkbinApplication.class, args);
    }

}
