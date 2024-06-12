package com.sujeet.CRMSpringMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujeet.CRMSpringMVC.dao.ICustomerRepo;
import com.sujeet.CRMSpringMVC.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	private ICustomerRepo repo;

	@Autowired
	public void setRepo(ICustomerRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Customer> getCustomerInfo() {
		return (List<Customer>) repo.findAll();
	}

	@Override
	public void registerCustomer(Customer customer) {
		repo.save(customer);
	}

}
