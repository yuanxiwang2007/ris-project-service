package com.rms.risproject;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.rms.risproject.mapper")
public class Application {

    public static void  main(String[] args){
        log.info("info:111111111");
        log.error("error:111111111");
        log.warn("warn:111111111");
        log.debug("debug:111111111");
        SpringApplication.run(Application.class,args);


    }
    @RequestMapping("")
    @ResponseBody
    String index(){
        return "欢迎光临";
    }
}
