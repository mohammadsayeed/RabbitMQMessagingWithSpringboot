package com.mq.mqProject.emp;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	private CountDownLatch latch = new CountDownLatch(1);
int i = 0;
    public void receiveMessage(String message) {
    	System.out.println("i=="+i++);
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }



}
