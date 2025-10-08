package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.FacultyDTO;

public class FacultyForm extends BaseForm {

	@NotEmpty(message = "please enter first name")
	private String firstName;

	@NotEmpty(message = "please enter last name")
	private String lastName;

	@NotNull(message = "please enter dob")
	private Date dob;

	@NotEmpty(message = "please enter gender")
	private String gender;

	@NotNull(message = "please enter phone no")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phoneNo;

	@NotEmpty(message = "please enter qualification" )
	private String qualification;

	@NotEmpty(message = "please enter email")
	@Email
	private String email;

	@NotNull(message = "please enter subject id")
	private Long subjectId;

	@NotNull(message = "please enter course id")
	private Long courseId;

	@NotNull(message = "please enter college id")
	private Long collegeId;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public BaseDTO getDto() {

		FacultyDTO dto = initDTO(new FacultyDTO());

		dto.setCollegeId(collegeId);
		dto.setCourseId(courseId);
		dto.setSubjectId(subjectId);
		dto.setDob(dob);
		dto.setEmail(email);
		dto.setFirstName(firstName);
		dto.setGender(gender);
		dto.setLastName(lastName);
		dto.setPhoneNo(phoneNo);
		dto.setQualification(qualification);

		return dto;
	}

}
