package kodlamaio.Hrms.Entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="JobSeekers")
public class JobSeekers extends User {
	
	@Id
	@GeneratedValue
	@Column(name="job_seekers_id")
	private int id;
	
	@Column(name="job_seekers_name")
	private String firstName;
	
	@Column(name="job_seekers_last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
    @Column(name="birth_date")
    private String birthDate;
	
	
	

}
