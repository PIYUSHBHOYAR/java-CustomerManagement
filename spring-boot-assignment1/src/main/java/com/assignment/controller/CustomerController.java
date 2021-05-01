package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Customers;
import com.assignment.exception.ResourceNotFoundException;
import com.assignment.repository.CustomerRepository;
import com.google.gson.Gson;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private Gson gson;
	
	/*
	 * method to get all customerdetails irrespective to there status 
	 */
	@GetMapping("/home")
	public List<Customers> getAllDetails(){
		return this.custRepo.findAll();
	}

	/*
	 * method to get all customerdetails by id
	 */
	@GetMapping("/{id}")
	public Customers getCustomersById(@PathVariable (value = "id") Long customer_Id) {
		return this.custRepo.findById(customer_Id).orElseThrow(() -> new ResourceNotFoundException("Customer do not Exist....."));
		
	}

	/*
	 * get details of active customers details respective to name and city
	 */	
	@GetMapping("/{name}/{city}")
	public String getCustomersByName(@PathVariable (value = "name") String customer_name,@PathVariable (value = "city") String city) {
		
		List<Customers> result = custRepo.getByName(customer_name, city);
		
		if(!result.isEmpty())
		{
			return gson.toJson(result);
		}
		else
		{
			return "{ Error : invalid Data }";
		}
	}
	
	/*
	 * method to create customer or insert customer
	 */	
	@PostMapping
	public Customers createCustomer(@RequestBody Customers customer) {
		return this.custRepo.save(customer);
	}
	
	/*
	 * update customer
	 */	
	@PutMapping("/update/{id}")
	public Customers updateCustomer(@RequestBody Customers customers , @PathVariable ("id") long customer_Id) {
		Customers exist = this.custRepo.findById(customer_Id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer do not Exist.....  " +customer_Id));
		
		exist.setCustomer_name(customers.getCustomer_name());
		exist.setCustomer_city(customers.getCustomer_city());
		exist.setBalance(customers.getBalance());
		exist.setCustomer_status(customers.isCustomer_status());
		
		return this.custRepo.save(exist);
		
	}
}
