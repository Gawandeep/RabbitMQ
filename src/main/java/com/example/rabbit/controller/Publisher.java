package com.example.rabbit.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbit.config.MQConfig;
import com.example.rabbit.dto.Customer;

@RestController
@RequestMapping("/publish")
public class Publisher {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@GetMapping("/{name}")
	public String publish(@PathVariable String name) {
		rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, new Customer(UUID.randomUUID().toString(),name));
		return "message Published";
	}

}
