package com.etiya.reCapProject.entities.concrates;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.etiya.reCapProject.core.entities.concrates.User;
import com.etiya.reCapProject.entities.abstracts.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "users")

public class ApplicationUser extends User {

	
	
	@JsonIgnore
	@OneToOne(mappedBy = "applicationUser")
	private Customer customer;
}
