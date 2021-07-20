package com.charter.customerTransactionService.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.charter.customerTransactionService.domain.CustomerTransaction;
import com.charter.customerTransactionService.service.TransactionService;
import com.charter.customerTransactionService.vo.Customer;


@RestController
@RequestMapping("/custTransaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/findByCustomerId/{id}")
	public List<CustomerTransaction> findByCustomerId(@PathVariable Long id) {
		return transactionService.findByCustomerId(id);
	}
	
	@PostMapping("/saveCustomerTransaction")
	public CustomerTransaction saveTransaction(@RequestBody CustomerTransaction transaction) {
		return transactionService.saveTransaction(transaction);
	}
	
	@GetMapping("/getAllTransactions")
	public List<CustomerTransaction> getAllTransactions() {
		return transactionService.findAllTransactions();
	}
	
	@GetMapping("/getLast3MonthsTransactionsByCustomer/{customerId}")
	public List<CustomerTransaction> getLast3MonthsTransactions(@PathVariable Long customerId) {
		return transactionService.getLast3MonthsTransactionsByCustomer(customerId);
	}
	
	@GetMapping("/findByTransactionId/{id}")
	public CustomerTransaction findByTransactionId(@PathVariable Long id) {
		return transactionService.findByTransactionId(id);
	}
	
	@GetMapping("/getLast3MonthsTransactions")
	public List<CustomerTransaction> getLast3MonthsTransactions(){
		// Get all required customers. design the get customers api to fetch desired list of customers.
		
		ResponseEntity<Customer[]> response =
				  restTemplate.getForEntity("http://localhost:9001/customer/findAllCustomers", Customer[].class);
		Customer[] threeMonthRecords = response.getBody();
		List<Customer> customerTransactionList =  Arrays.stream(threeMonthRecords).collect(Collectors.toList());

		
		List<Long> customerIdList =  customerTransactionList.stream().map(x-> x.getCutomerId()).collect(Collectors.toList());
		
		return transactionService.getLast3MonthsTransactions(customerIdList);
	}
	
}
