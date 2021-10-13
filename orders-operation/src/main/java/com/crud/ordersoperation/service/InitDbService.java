package com.crud.ordersoperation.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ordersoperation.entity.OrderItem;
import com.crud.ordersoperation.repository.OrderItemRepository;

@Service
public class InitDbService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setName("example");
			orderItem.setUrl("http://www.example.com");
			orderItemRepository.save(orderItem);
		}
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setName("orderItemorderItem");
			orderItem.setUrl("http://orderItemorderItem.net");
			orderItemRepository.save(orderItem);
		}
		{
			OrderItem orderItem = new OrderItem();
			orderItem.setName("javavids");
			orderItem.setUrl("http://www.javavids.com");
			orderItemRepository.save(orderItem);
		}
		System.out.println("*** INIT DATABASE FINISH ***");
	}
}
