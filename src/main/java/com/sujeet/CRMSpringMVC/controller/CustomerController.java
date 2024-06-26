package com.sujeet.CRMSpringMVC.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sujeet.CRMSpringMVC.model.Customer;
import com.sujeet.CRMSpringMVC.service.ICustomerService;

@Controller
public class CustomerController {
	// @Autowired or with setter
	private ICustomerService service;

	@Autowired
	public void setService(ICustomerService service) {
		this.service = service;
	}

	@GetMapping("/cxlist")
	public String getCustomerData(Model model) {
		List<Customer> customerList = service.getCustomerInfo();
		model.addAttribute("customers", customerList);
		return "customerlist";
	}

	@GetMapping("/showForm")
	public String getForm(Map<String, Object> model) {
		Customer c = new Customer();
		model.put("customer", c);
		return "showform";
	}

	@PostMapping("/registerCustomer")
	public String registerCustomer(@ModelAttribute("customer") Customer customer, Map<String, Object> model) {
		service.registerCustomer(customer);
		return "redirect:/cxlist";
	}

	@GetMapping("/updateForm")
	public String updateCxInfo(@RequestParam("customerId") Integer id, Map<String, Object> model) {
		Optional<Customer> cx = service.fetchCustomerById(id);
		model.put("customer", cx);
		return "updateform";
	}

	@GetMapping("/deleteData")
	public String deleteCxInfo(@RequestParam("customerId") Integer id) {
		service.deleteCustomer(id);
		System.out.println("Customer with id" + id + " deleted successfully");
		return "redirect:/cxlist";
	}
}
