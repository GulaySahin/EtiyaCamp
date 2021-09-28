package com.etiya.reCapProject.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.etiya.reCapProject.entities.concrates.RentAl;

public interface RentAlDao extends JpaRepository<RentAl, Integer>{

	
    List<RentAl> getByCar_CarId(int carId);
	
	RentAl getByRentAlId(int id);
}
