package kodlamaio.Hrms.Entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Employers")
public class Employers extends User {

	@Id
	@GeneratedValue
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="Company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="web_address")
	private String webAddress;
	
	
}
