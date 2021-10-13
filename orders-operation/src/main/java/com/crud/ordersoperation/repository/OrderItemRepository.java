package com.crud.ordersoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.ordersoperation.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
