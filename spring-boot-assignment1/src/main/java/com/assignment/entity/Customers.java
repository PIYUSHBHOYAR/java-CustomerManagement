package com.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerDetails")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long customer_Id;
	
	@Column
	private String customer_name;
	@Column
	private String customer_city;
	@Column
	private double balance;
	@Column
	private boolean customer_status;
	
	public Customers() {
		
	}
	
	public Customers(String customer_name, String customer_city, double balance, boolean customer_status) {
		super();
		this.customer_name = customer_name;
		this.customer_city = customer_city;
		this.balance = balance;
		this.customer_status = customer_status;
	}
	
	public long getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(long customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_city() {
		return customer_city;
	}
	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isCustomer_status() {
		return customer_status;
	}
	public void setCustomer_status(boolean customer_status) {
		this.customer_status = customer_status;
	}
	
	
}
