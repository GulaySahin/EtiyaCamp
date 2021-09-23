package com.etiya.reCapProject.dataAccess.abstracts;

  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.etiya.reCapProject.entities.concrates.CreditCard;
import com.etiya.reCapProject.entities.concrates.Customer;
  
  public interface CreditCardDao extends JpaRepository<CreditCard, Integer>{
  
	  Customer getByCustomer_Id(int customerId);

	 List<CreditCard> getCreditCardByCustomer_Id(int customerId);
  }
 