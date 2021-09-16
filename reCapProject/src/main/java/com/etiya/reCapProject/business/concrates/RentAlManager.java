package com.etiya.reCapProject.business.concrates;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.RentAlService;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.RentAlDao;
import com.etiya.reCapProject.entities.concrates.RentAl;

@Service
public class RentAlManager implements RentAlService  {
	
	private RentAlDao rentAlDao;
	
    @Autowired
	public RentAlManager(RentAlDao rentAlDao) {
		super();
		this.rentAlDao = rentAlDao;
	}

	@Override
	public DataResult<List<RentAl>> getAll() {
		List<RentAl>rental=this.rentAlDao.findAll();
		return new SuccessDataResult<>(rental,"listelendi");
	}

	@Override
	public DataResult<RentAl> getById(int carId) {
		RentAl rental=this.rentAlDao.getById(carId);
		return new SuccessDataResult<RentAl>(rental,"id'ye göre listelendi");
		
	}

	@Override
	public Result add(RentAl rental) {
	var result=BusinessRules.run(checkCarIsSubmit(rental.getCar().getCarId()));
	if(result!=null) {
		return result;
	}
	this.rentAlDao.save(rental);
	
	return new SuccessResult("bilgiler eklendi");
		
	}

	@Override
	public Result update(RentAl rental) {
		this.rentAlDao.save(rental);
		return new SuccessResult("Kiralama güncellendi");
	}

	@Override
	public Result delete(RentAl rental) {
		this.rentAlDao.delete(rental);
		return new SuccessResult("Kiralama silindi");
	}
    
    public Result checkCarIsSubmit(int carId) {
    	for (RentAl rental : this.rentAlDao.getByCar_carId(carId)) {
            if(rental.getReturnDate() == null ) {
                
                return new ErrorResult("Teslim edilmemistir. Arac Kiralanamaz.");
            }
        }
        return new SuccessResult();
    }
}
