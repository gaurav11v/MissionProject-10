package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDTO;

public class RoleForm extends BaseForm {

	@NotEmpty(message = "Please enter role name")
	private String name = null;

	@NotEmpty(message = "Please enter role description")
	private String description = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BaseDTO getDto() {
		RoleDTO dto = initDTO(new RoleDTO());

		dto.setName(name);
		dto.setDescription(description);
		return dto;
	}

}
