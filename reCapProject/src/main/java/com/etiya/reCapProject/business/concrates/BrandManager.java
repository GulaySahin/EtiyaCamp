package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.BrandService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.business.BusinessRules;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.BrandDao;
import com.etiya.reCapProject.entities.concrates.Brand;
import com.etiya.reCapProject.entities.request.brandRequest.AddBrandRequest;
import com.etiya.reCapProject.entities.request.brandRequest.DeleteBrandRequest;
import com.etiya.reCapProject.entities.request.brandRequest.UpdateBrandRequest;
import com.etiya.reCapProject.core.utilities.results.ErrorResult;

@Service
public class BrandManager implements BrandService {
  
	private BrandDao brandDao;
	
	@Autowired
	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao=brandDao;
	}

	@Override
	public DataResult<List<Brand>> getBybrandId(int brandId) {
		List<Brand> brands =this.brandDao.getBybrandId(brandId);
		return new SuccessDataResult<>(brands,Messages.LIST);
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		
	List<Brand> brands=this.brandDao.findAll();
	return new SuccessDataResult<>(brands,Messages.LIST);
	}

	@Override
	public Result add(AddBrandRequest addBrandRequest) {
		
	var result = BusinessRules.run(checkBrandName(addBrandRequest.getBrandName()));
        if (result != null) {
            return result;
        }
	 Brand brand=new Brand();
	 
	 brand.setBrandName(addBrandRequest.getBrandName());
	 this.brandDao.save(brand);
	 return new SuccessResult(Messages.ADD);
		
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		 Brand brand=this.brandDao.getById(updateBrandRequest.getBrandId());
		 brand.setBrandId(updateBrandRequest.getBrandId());
		 brand.setBrandName(updateBrandRequest.getBrandName());
		 
		 this.brandDao.save(brand);
		 return new SuccessResult(Messages.UPDATE);
	}

	@Override
	public Result delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand=new Brand();
		brand.setBrandId(deleteBrandRequest.getBrandId());
		
		this.brandDao.delete(brand);
		 return new SuccessResult(Messages.DELETE);
	}
	
	public Result checkBrandName(String brandName) {

        if (this.brandDao.existsBrandByBrandName(brandName)) {
            return new ErrorResult(Messages.BRANDERROR);
        }
        return new SuccessResult();
    }

	


}
