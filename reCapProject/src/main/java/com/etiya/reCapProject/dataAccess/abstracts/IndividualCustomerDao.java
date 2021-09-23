package com.etiya.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.etiya.reCapProject.entities.concrates.IndividualCustomer;

public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, Integer> {

	IndividualCustomer getByIdentityNumber(String identityNumber);
	
}
