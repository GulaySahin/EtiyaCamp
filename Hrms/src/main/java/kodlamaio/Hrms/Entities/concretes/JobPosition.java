package kodlamaio.Hrms.Entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Job_Pozition")
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="job_id")
	private int id;
	@Column(name="job_name")
	private String name;
	
	

	
	
}
