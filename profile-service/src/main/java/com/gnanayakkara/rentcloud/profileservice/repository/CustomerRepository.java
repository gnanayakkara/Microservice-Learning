package com.gnanayakkara.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gnanayakkara.rentcloud.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
