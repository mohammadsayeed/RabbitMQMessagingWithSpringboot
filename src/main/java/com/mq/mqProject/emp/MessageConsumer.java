package com.mq.mqProject.emp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageConsumer {


    @Value("${javainuse.rabbitmq.queue}")
    String queueName;
   // @Scheduled(fixedDelay = 10L)
    @RabbitListener(queues = "javainuse.queue")
    public void handleForwardEngineeringRequest(String jsonString) throws IOException {




        System.out.println(" i m in listner");
        Employee request = new ObjectMapper().readValue(jsonString, Employee.class);
        System.out.println("User Id **************" + request.getEmpId());
        System.out.println("Password **************" + request.getEmpName());
    }
}