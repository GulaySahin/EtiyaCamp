package kodlamaio.Hrms.DataAccess.abstractt;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.Entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
