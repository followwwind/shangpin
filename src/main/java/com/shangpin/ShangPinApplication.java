package com.shangpin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(value = {"com.shangpin.mapper","com.shangpin.dao"})
@ServletComponentScan
public class ShangPinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShangPinApplication.class, args);
    }
}
