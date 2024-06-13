package com.sujeet.CRMSpringMVC.service;

import java.util.List;
import java.util.Optional;

import com.sujeet.CRMSpringMVC.model.Customer;

public interface ICustomerService {
	public List<Customer> getCustomerInfo();

	public void registerCustomer(Customer customer);

	public Optional<Customer> fetchCustomerById(Integer id);

	public void deleteCustomer(Integer id);
}
