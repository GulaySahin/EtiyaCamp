package com.etiya.reCapProject.entities.request.colorRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateColorRequest {

	private int colorId;
	
	private String colorName;
}
