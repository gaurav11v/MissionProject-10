package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.MarksheetDTO;

public class MarksheetForm extends BaseForm {

	@NotEmpty(message = "please enter roll no")
	protected String rollNo = null;

	@NotNull(message = "please enter physics no")
	protected Integer physics;

	@NotNull(message = "please enter chemistry no")
	protected Integer chemistry;

	@NotNull(message = "please enter maths no")
	protected Integer maths;

	@NotNull(message = "please enter student id")
	protected Long studentId;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public BaseDTO getDto() {

		MarksheetDTO dto = initDTO(new MarksheetDTO());

		dto.setChemistry(chemistry);
		dto.setMaths(maths);
		dto.setPhysics(physics);
		dto.setRollNo(rollNo);
		dto.setStudentId(studentId);
		dto.setName(name);

		return dto;
	}

}
