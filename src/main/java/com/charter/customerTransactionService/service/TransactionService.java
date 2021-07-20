package com.charter.customerTransactionService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.customerTransactionService.domain.CustomerTransaction;
import com.charter.customerTransactionService.repository.TransactionRepository;


@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<CustomerTransaction> findByCustomerId(Long customerId) {
		return transactionRepository.findByCustomerId(customerId);
	}
	
	public CustomerTransaction saveTransaction(CustomerTransaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	
	public List<CustomerTransaction> findAllTransactions() {
		return transactionRepository.findAll();
	}
	
	public List<CustomerTransaction> getLast3MonthsTransactionsByCustomer(Long customerId) {
		return transactionRepository.getLast3MonthsTransactionsByCustomer(customerId);
	}
	
	public CustomerTransaction findByTransactionId(Long id) {
		return transactionRepository.findByTransactionId(id);
	}
	
	public List<CustomerTransaction> getLast3MonthsTransactions(List<Long> customerIdList) {
		return transactionRepository.getLast3MonthsTransactions(customerIdList);
	}
	
}
