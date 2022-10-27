package com.example.rabbit.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbit.config.MQConfig;
import com.example.rabbit.dto.Customer;

@Component
public class CustomerListener {

	@RabbitListener(queues = MQConfig.QUEUE)
	public void customerConsumer(Customer customer) {
		System.out.println(customer);
	}
	
}
