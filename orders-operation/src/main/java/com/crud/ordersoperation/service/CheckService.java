package com.crud.ordersoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ordersoperation.entity.Check;
import com.crud.ordersoperation.repository.CheckRepository;

@Service
public class CheckService {

	@Autowired
	private CheckRepository checkRepository;
	
	public List<Check> findAll() {
		return checkRepository.findAll();
	}

	public void save(Check check) {
		checkRepository.save(check);
	}

	public void remove(Check check) {
		checkRepository.delete(check);
	}

}
