package com.etiya.reCapProject.business.abstracts;


  import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.CreditCard;
import com.etiya.reCapProject.entities.request.creditCardRequest.AddCreditCardRequest;
import com.etiya.reCapProject.entities.request.creditCardRequest.DeleteCreditCardRequest;
import com.etiya.reCapProject.entities.request.creditCardRequest.UpdateCreditCardRequest;
 
  
  public interface CreditCardService {
  
  DataResult<List<CreditCard>> getAll();
  
  DataResult<CreditCard> getById(int id);
  

  
  DataResult<List<CreditCard>> getCreditCardByCustomer_CustomerId(int customerId);
  
  Result add(AddCreditCardRequest addCreditCardRequest);
  
  Result delete(DeleteCreditCardRequest deleteCreditCardRequest);
  
  Result update(UpdateCreditCardRequest updateCreditCardRequest);
  

  }
 