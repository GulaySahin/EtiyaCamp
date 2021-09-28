package com.etiya.reCapProject.business.abstracts;

import java.util.Date;
import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.Invoice;
import com.etiya.reCapProject.entities.request.invoiceRequest.AddInvoiceRequest;
import com.etiya.reCapProject.entities.request.invoiceRequest.DeleteInvoiceRequest;
import com.etiya.reCapProject.entities.request.invoiceRequest.UpdateInvoiceRequest;

public interface InvoiceService {

DataResult<List<Invoice>> getAll();
	
	DataResult<List<Invoice>> getByCustomerId(int customerId);
	
	DataResult<List<Invoice>> getInvoicesBetweenTwoDate(Date startDate, Date endDate );

	
	Result add(AddInvoiceRequest addInvoiceRequest);
	
	Result update(UpdateInvoiceRequest updateInvoiceRequest);
	
	Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
}
