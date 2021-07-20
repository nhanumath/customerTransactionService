package com.charter.customerTransactionService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.charter.customerTransactionService.domain.CustomerTransaction;


@Repository
public interface TransactionRepository extends JpaRepository<CustomerTransaction, Long> {

	public List<CustomerTransaction> findByCustomerId(Long customerId);
	
	@Query(value="select * from CustomerTransaction where transactionDate >= DATEADD('MONTH',-3, CURRENT_DATE) and customerId=?1",nativeQuery=true)
	public List<CustomerTransaction> getLast3MonthsTransactionsByCustomer(Long customerId);
	
	
	public CustomerTransaction findByTransactionId(Long id);
	
	
	@Query(value="select * from CustomerTransaction where transactionDate >= DATEADD('MONTH',-3, CURRENT_DATE) and customerId in (?1)",nativeQuery=true)
	public List<CustomerTransaction> getLast3MonthsTransactions(List<Long> customerIdList);
	
}
