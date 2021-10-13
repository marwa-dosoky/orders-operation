package com.crud.ordersoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ordersoperation.entity.OrderItem;
import com.crud.ordersoperation.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> findAll() {
		return orderItemRepository.findAll();
	}

	public void save(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}

	public void remove(OrderItem orderItem) {
		orderItemRepository.delete(orderItem);
	}

}
