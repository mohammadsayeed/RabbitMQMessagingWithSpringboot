package com.mq.mqProject.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.invoke.empty.Empty;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@PostMapping(value = "/producer")
		public String producer(@RequestBody Employee emp) {
			
		/*String empId = "kk";
		String empName = "hghgh";
	Employee emp=new Employee(empId,empName);
	emp.setEmpId(empId);
	emp.setEmpName(empName);*/
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}

	
}

