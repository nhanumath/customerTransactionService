package com.charter.customerTransactionService.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERTRANSACTION")
public class CustomerTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transactionId")
	private Long transactionId;
	@Column(name="CUSTOMERID")
	private Long customerId;
	@Column(name="TRANSACTIONDATE")
	private Date transactionDate;
	@Column(name="amountSpent")
	private Double amountSpent;
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(Double amountSpent) {
		this.amountSpent = amountSpent;
	}
	
	
	
	
}
