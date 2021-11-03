package com.crud.ordersoperation.service;

import java.util.stream.IntStream;

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
		System.out.println("*** CREAT SAMPLE DATA ***");
		
		IntStream.range(0, 5).forEach(idx -> {
			OrderItem orderItem = new OrderItem();
			orderItem.setName("example"+idx);
			orderItem.setDescription("example description:"+idx);
			orderItem.setEmail("example"+idx+"@mail.com");
			orderItem.setNum(idx);
			orderItemRepository.save(orderItem);
		});
		

		System.out.println("*** INIT DATABASE FINISH ***");
	}
}
