package com.sujeet.CRMSpringMVC.service;

import java.util.List;

import com.sujeet.CRMSpringMVC.model.Customer;

public interface ICustomerService {
	public List<Customer> getCustomerInfo();

	public void registerCustomer(Customer customer);
}
