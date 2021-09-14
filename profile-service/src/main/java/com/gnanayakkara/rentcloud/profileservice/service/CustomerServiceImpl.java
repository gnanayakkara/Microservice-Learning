package com.gnanayakkara.rentcloud.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnanayakkara.rentcloud.commons.model.Customer;
import com.gnanayakkara.rentcloud.profileservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer fetchFindByID(int id) {

		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()){
			return customer.get();
		}
		return null;
	}
	
	@Override
	public List<Customer> fetchAll() {
		return customerRepository.findAll();
	}
}
