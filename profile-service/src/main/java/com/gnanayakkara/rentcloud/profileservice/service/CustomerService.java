package com.gnanayakkara.rentcloud.profileservice.service;

import java.util.List;

import com.gnanayakkara.rentcloud.commons.model.Customer;

public interface CustomerService {

	Customer save(Customer customer);
	
	public Customer fetchFindByID(int id);
	
	public List<Customer> fetchAll();
}
