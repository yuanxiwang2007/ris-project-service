package com.rms.risproject;

import com.rms.risproject.model.response.BaseUserResp;
import com.rms.risproject.service.RedisService;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


@Log4j
@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.rms.risproject.mapper")
public class Application {
    //@Autowired
    //private RedisService redisService;
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
