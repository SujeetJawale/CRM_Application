package com.sujeet.CRMSpringMVC.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sujeet.CRMSpringMVC.model.Customer;

@Repository // Adding @Repository here is optional
public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
