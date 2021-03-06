package com.etiya.reCapProject.entities.concrates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="corporate_customers")

public class CorporateCustomer extends Customer {
	
	
	@Column(name="tax_number")
	private String taxNumber;
	
	
	@Column(name="company_name")
	private String companyName;

}
