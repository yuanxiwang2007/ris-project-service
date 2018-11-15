package com.rms.risproject.controller;

import com.alibaba.fastjson.JSON;
import com.rms.risproject.model.response.BaseUserResp;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        //向mq服务端发送消息，exchange为log，routingkey为log.error
        String context = "error log";
        this.rabbitTemplate.convertAndSend("log", "log.error", context);

        //向mq服务端发送消息，exchange为log，routingkey为log.info
        context = "info log";
        System.out.println("send msg : " + context);
        this.rabbitTemplate.convertAndSend("log", "log.info", context);

        //向mq服务端发送消息，exchange为log，routingkey为log.warn
        context = "warn log";
        System.out.println("send msg : " + context);
        this.rabbitTemplate.convertAndSend("log", "log.warn", context);
        context = "sms Code";
        //System.out.println("send msg : " + context);
        //this.rabbitTemplate.convertAndSend("log", "log.code", context);


        BaseUserResp baseUserResp=new BaseUserResp();
        baseUserResp.setCode("code001");
        baseUserResp.setName("袁希望");
        baseUserResp.setPhoneNo("13308170263");

        System.out.println("send msg : " + JSON.toJSONString(baseUserResp));
        this.rabbitTemplate.convertAndSend("msgCode", JSON.toJSONString(baseUserResp));
    }

}

