package com.mq.mqProject.emp;

import org.apache.logging.log4j.message.Message;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

@Service
public class CustomMessageListener {

    //private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

   /* @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }
*/
 // @Scheduled()
   //@Scheduled(initialDelay = 1000, fixedRate = 10000)
    @RabbitListener(queues ="javainuse.queue")
    public void receiveMessage(final Employee customMessage) {
        System.out.println("Received message as specific class: {}"+customMessage.toString());
    }
/*
    private CountDownLatch latch = new CountDownLatch(1);
    public CountDownLatch getLatch() {
        return latch;
    }*/

    /*@Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        System.out.println("Current time is :: " + Calendar.getInstance().getTime());
    }*/
}