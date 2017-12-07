package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.pluralsight.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	@Value("${dbuserName}")
	private String dbUserName;
	
	@Override
	public List<Customer> findAll(){
		System.out.println(dbUserName);
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer();
		customer.setFirstName("Ninad");
		customer.setLastName("Phalak");
		customers.add(customer);
		return customers;
	}

}
