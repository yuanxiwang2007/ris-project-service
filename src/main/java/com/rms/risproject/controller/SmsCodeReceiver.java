package com.rms.risproject.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "msgCode")
public class SmsCodeReceiver {
    @RabbitHandler
    public void process(String context) {
        System.out.println("receive sms.Code : " + context);
    }
}