package com.etiya.reCapProject.business.concrates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.reCapProject.business.abstracts.ColorService;
import com.etiya.reCapProject.business.constants.Messages;
import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.reCapProject.core.utilities.results.SuccessResult;
import com.etiya.reCapProject.dataAccess.abstracts.ColorDao;
import com.etiya.reCapProject.entities.concrates.Color;
import com.etiya.reCapProject.entities.request.AddColorRequest;
import com.etiya.reCapProject.entities.request.UpdateColorRequest;
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
		return new SuccessDataResult<>(colors,Messages.List);
	}

	@Override
	public DataResult<List<Color>> getAll() {
		List<Color> colors=this.colorDao.findAll();
		return new SuccessDataResult<>(colors,Messages.List);
	}
	@Override
	public Result add(AddColorRequest addColorRequest) {
		Color color=new Color();
		color.setColorName(addColorRequest.getColorName());
		this.colorDao.save(color);
		return new SuccessResult(Messages.Add);
	}

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
			Color color=new Color();
			color.setColorName(updateColorRequest.getColorName());
		this.colorDao.save(color);
		return new SuccessResult(Messages.Update);
	}

	@Override
	public Result delete(int colorId) {
		this.colorDao.deleteById(colorId);
		return new SuccessResult(Messages.Delete);
	}

	
	

}
