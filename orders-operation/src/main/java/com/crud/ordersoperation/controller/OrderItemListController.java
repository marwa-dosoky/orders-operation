package com.crud.ordersoperation.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.crud.ordersoperation.entity.OrderItem;
import com.crud.ordersoperation.service.OrderItemService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class OrderItemListController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{orderItemService}")
	private OrderItemService orderItemService;
	
	private List<OrderItem> orderItems;
	
	private OrderItem orderItem = new OrderItem();
	
	@PostConstruct
	public void loadOrderItems() {
		orderItems = orderItemService.findAll();
	}
	
	public void save() {
		orderItemService.save(orderItem);
		orderItem = new OrderItem();
		orderItems = orderItemService.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OrderItem saved!", null));
	}
	
	public void remove(OrderItem orderItem) {
		orderItemService.remove(orderItem);
		orderItems = orderItemService.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OrderItem removed!", null));
	}
	
	public void clear() {
		orderItem = new OrderItem();
	}

}
