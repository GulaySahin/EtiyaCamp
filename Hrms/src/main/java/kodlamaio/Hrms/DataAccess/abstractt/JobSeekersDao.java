package kodlamaio.Hrms.DataAccess.abstractt;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.Entities.concretes.JobSeeker;

public interface JobSeekersDao extends JpaRepository<JobSeeker, Integer> {

}
