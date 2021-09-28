package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.etiya.reCapProject.entities.concrates.CareCar;
@Repository
public interface CareCarDao extends JpaRepository<CareCar, Integer>{


	
	List<CareCar> getByCar_CarId(int carId);
	

}
