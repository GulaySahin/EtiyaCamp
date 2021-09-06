package kodlamaio.Hrms.DataAccess.abstractt;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.Entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{

}
