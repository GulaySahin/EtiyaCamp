package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.ColorService;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.ColorDao;
import com.etiya.reCapProject.entities.concrates.Color;
@Service
public class ColorManager implements ColorService{
	
	private ColorDao colorDao;
    
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao=colorDao;
	}

	@Override
	public DataResult<List<Color>> getBycolorId(int colorId) {
		List<Color> colors=this.colorDao.getBycolorId(colorId);
		return new SuccessDataResult<>(colors," colorId'ye göre listelendi");
	}

	@Override
	public DataResult<List<Color>> getAll() {
		List<Color> colors=this.colorDao.findAll();
		return new SuccessDataResult<>(colors," Tüm renkler listelendi");
	}
	@Override
	public Result add(Color color) {
		this.colorDao.save(color);
		return new SuccessResult(color.getColorName()+" rengi eklendi");
	}

	@Override
	public Result update(Color color) {
		this.colorDao.save(color);
		return new SuccessResult("güncellendi");
	}

	@Override
	public Result delete(Color color) {
		this.colorDao.delete(color);
		return new SuccessResult("silindi");
	}

	
	

}
