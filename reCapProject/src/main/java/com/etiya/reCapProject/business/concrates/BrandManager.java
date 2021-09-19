package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.reCapProject.business.abstracts.BrandService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.BrandDao;
import com.etiya.reCapProject.entities.concrates.Brand;
import com.etiya.reCapProject.entities.request.AddBrandRequest;
import com.etiya.reCapProject.entities.request.UpdateBrandRequest;

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
		return new SuccessDataResult<>(brands,Messages.List);
	}

	@Override
	public DataResult<List<Brand>> getAll() {
		
	List<Brand> brands=this.brandDao.findAll();
	return new SuccessDataResult<>(brands,Messages.List);
	}

	@Override
	public Result add(AddBrandRequest addBrandRequest) {
	 Brand brand=new Brand();
	 
	 brand.setBrandName(addBrandRequest.getBrandName());
	 this.brandDao.save(brand);
	 return new SuccessResult(Messages.Add);
		
	}

	@Override
	public Result update(UpdateBrandRequest updateBrandRequest) {
		 Brand brand=new Brand();
		 brand.setBrandName(updateBrandRequest.getBrandName());
		 
		 this.brandDao.save(brand);
		 return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(int brandId) {
		
		this.brandDao.deleteById(brandId);
		 return new SuccessResult(Messages.Delete);
	}

	


}
