package com.rms.risproject.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogRabbitConfig {
    final static String QUEUE_LOG_ERROR = "log.error";
    final static String QUEUE_LOG_ALL = "log.all";

    //创建log.error队列
    @Bean
    public Queue logError() {
        return new Queue(QUEUE_LOG_ERROR);
    }
    //创建log.all队列
    @Bean
    public Queue logAll() {
        return new Queue(QUEUE_LOG_ALL);
    }
    //创建exchange，命名为log
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("log");
    }
    //绑定log.error队列到exchange，routingkey为log.error
    @Bean
    Binding bindingExchangeError(Queue logError, TopicExchange exchange) {
        return BindingBuilder.bind(logError).to(exchange).with("log.error");
    }
    //绑定log.all队列到exchange，routingkey为log.#
    @Bean
    Binding bindingExchangeAll(Queue logAll, TopicExchange exchange) {
        return BindingBuilder.bind(logAll).to(exchange).with("log.#");
    }
}
