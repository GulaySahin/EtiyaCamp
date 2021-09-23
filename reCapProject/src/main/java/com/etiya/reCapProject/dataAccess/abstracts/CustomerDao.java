package com.etiya.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.reCapProject.entities.concrates.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	boolean existsCustomerByeMail(String eMail);
}
