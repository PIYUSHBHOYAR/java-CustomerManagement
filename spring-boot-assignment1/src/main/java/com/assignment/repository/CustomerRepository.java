package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long>{
	
	@Query("FROM Customers c where c.customer_name = :name and c.customer_city = :city and c.customer_status=1")
	public List<Customers> getByName(@Param("name") String name, @Param("city") String city);
}
