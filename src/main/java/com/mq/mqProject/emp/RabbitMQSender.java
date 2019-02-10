package com.mq.mqProject.emp;

import java.io.File;
import java.io.InputStream;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee company) {
		
		/*File f = new File("application");
		System.out.println("  path === "+f.getAbsolutePath());
		
		File ff = new File("resources/mksd.jks");
		System.out.println("=====mnnnm===>"+ff.getAbsolutePath());
		if(ff.exists())
		{
		System.out.println("========>"+ff.getAbsolutePath());
		}
		System.out.println();
		*/rabbitTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("exchange, routingkey"+exchange+""+ routingkey);
		System.out.println("Send msg = " + company);
	    
	}
}
