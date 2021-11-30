package com.gnanayakkara.rentcloud.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnanayakkara.rentcloud.commons.model.Customer;
import com.gnanayakkara.rentcloud.profileservice.service.CustomerService;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('create_profile')")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public ResponseEntity<Customer> fetchCustomer(@ RequestParam int id){
		Customer customer = customerService.fetchFindByID(id);
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(customer);
	}
	
	@RequestMapping(value = "/profiles",method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_operator')")
	public ResponseEntity<List<Customer>> fetchAllCustomers(){
		List<Customer> customers = customerService.fetchAll();
		if(customers == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(customers);
	}
}
