package com.rms.risproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.rms.risproject.mapper")
public class Application {

    public static void  main(String[] args){
        SpringApplication.run(Application.class,args);
        System.out.printf("启动成功！");
    }
    @RequestMapping("")
    @ResponseBody
    String index(){
        return "欢迎光临";
    }
}
