package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.StudentDTO;

public class StudentForm extends BaseForm {

	@NotEmpty(message = "please enter enroll no")
	private String enrollNo;

	@NotEmpty(message = "please enter first name")
	private String firstName;

	@NotEmpty(message = "please enter last name")
	private String lastName;

	@NotNull(message = "please enter dob")
	private Date dob;

	@NotEmpty(message = "please enter phone no")
	private String phoneNo;

	@NotEmpty(message = "please enter email")
	private String email;

	@NotNull(message = "please enter college id")
	private Long collegeId;

	private String collegeName;

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getEnrollNo() {
		return enrollNo;
	}

	public void setEnrollNo(String enrollNo) {
		this.enrollNo = enrollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public BaseDTO getDto() {

		StudentDTO dto = initDTO(new StudentDTO());

		dto.setCollegeId(collegeId);
		dto.setCollegeName(collegeName);
		dto.setDob(dob);
		dto.setEmail(email);
		dto.setEnrollNo(enrollNo);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setPhoneNo(phoneNo);

		return dto;
	}

}
