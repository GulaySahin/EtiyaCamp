package kodlamaio.Hrms.Entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="System_personnel")
public class SystemPersonnel extends User {

	
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@Column(name="position_name")
	private String name;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
}
