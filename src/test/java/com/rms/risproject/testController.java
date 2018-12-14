package com.rms.risproject;

import com.rms.risproject.controller.BaseUserController;
import com.rms.risproject.model.response.BaseUserResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration
public class testController {
    @Autowired
    private BaseUserController baseUserController;

    @Test
    public void add() {
        BaseUserResp baseUserResp = new BaseUserResp();
        baseUserResp.setAge(10);
        baseUserResp.setPhoneNo("A23123123123");
        baseUserResp.setName("Aasdasdasd");
        baseUserResp.setCode("Aerw434");
        baseUserResp.setLoginName("Acduhope");
        baseUserResp.setLoginPwd("A123456");
        baseUserResp.setKeyId(UUID.randomUUID().toString().replace("-", ""));
        //baseUserController.saveTest(baseUserResp);
        baseUserController.save(baseUserResp);

    }

}
