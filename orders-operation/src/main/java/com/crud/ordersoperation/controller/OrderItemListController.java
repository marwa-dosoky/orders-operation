package com.crud.ordersoperation.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.crud.ordersoperation.SpringConfiguration;
import com.crud.ordersoperation.entity.*;
import com.crud.ordersoperation.service.*;

import lombok.Getter;
import lombok.Setter;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

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
//		printPDF();
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
	
	public void printPDF() {
		SpringConfiguration configuration=new SpringConfiguration();
		JasperReportBuilder report = DynamicReports.report();//a new report
		try {
			report
			  .columns(
			  	Columns.column("Order Number", "num", DataTypes.integerType())
			  		.setHorizontalAlignment(HorizontalAlignment.LEFT),
			  	Columns.column("Order Name", "name", DataTypes.stringType()),
			  	Columns.column("Order Description", "description", DataTypes.stringType()),
			  	Columns.column("Order Email", "email", DataTypes.stringType())
			  		.setHorizontalAlignment(HorizontalAlignment.LEFT)
			  	)
			  .title(//title of the report
			  	Components.text("SimpleReportExample")
			  		.setHorizontalAlignment(HorizontalAlignment.CENTER))
			  .pageFooter(Components.pageXofY()).setDataSource("SELECT * FROM OrderItem",configuration.dataSource().getConnection());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//show page number on the page footer

		try {
			report.show();//show the report

		} catch (DRException e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OrderItem saved!", null));
	}
	public void clear() {
		orderItem = new OrderItem();
	}

}
