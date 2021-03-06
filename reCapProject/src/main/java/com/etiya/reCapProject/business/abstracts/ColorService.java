package com.etiya.reCapProject.business.abstracts;

import java.util.List;

import com.etiya.reCapProject.core.utilities.results.DataResult;
import com.etiya.reCapProject.core.utilities.results.Result;
import com.etiya.reCapProject.entities.concrates.Color;
import com.etiya.reCapProject.entities.request.colorRequest.AddColorRequest;
import com.etiya.reCapProject.entities.request.colorRequest.DeleteColorRequest;
import com.etiya.reCapProject.entities.request.colorRequest.UpdateColorRequest;

public interface ColorService {
	DataResult<List<Color>> getBycolorId(int colorId);

	DataResult<List<Color>> getAll();

	Result add(AddColorRequest addColorRequest);

	Result update(UpdateColorRequest updateColorRequest);

	Result delete(DeleteColorRequest deleteColorRequest);

}
