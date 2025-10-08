package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubjectDTO;

public class SubjectForm extends BaseForm {

	@NotEmpty(message = "please enter name")
	private String name;

	@NotNull(message = "please enter course id")
	private Long courseId;

	@NotEmpty(message = "please enter description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BaseDTO getDto() {

		SubjectDTO dto = initDTO(new SubjectDTO());
		dto.setCourseId(courseId);
		System.out.println("course id => " +dto.getCourseId());
		dto.setDescription(description);
		dto.setName(name);

		return dto;
	}

}
