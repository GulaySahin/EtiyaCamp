package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.Color;

public interface ColorService {
	DataResult<List<Color>> getBycolorId(int colorId);

	DataResult<List<Color>> getAll();

	Result add(Color color);

	Result update(Color color);

	Result delete(Color color);

}
