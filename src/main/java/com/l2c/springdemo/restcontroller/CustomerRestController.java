package com.l2c.springdemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.l2c.springdemo.entity.Customer;
import com.l2c.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
	}
	
	// add mapping for /customer/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer not found for the id - "+customerId);
		}
		return theCustomer;
	}
	
	//add post mapping for adding a new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//add support for put mapping for /customers
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//add support for delete mapping for /customers
		@DeleteMapping("/customers/{customerId}")
		public String deleteCustomer(@PathVariable int customerId) {
			Customer tempCustomer = customerService.getCustomer(customerId);
			if(tempCustomer==null) {
				throw new CustomerNotFoundException("Customer not found for the id "+customerId);
			}
			
			customerService.deleteCustomer(customerId);
			return "Deleted customer for id - "+customerId;
		}
	
	
}
