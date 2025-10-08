package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * Student POJO class. It is persistent object.
 * 
 */

@Entity
@Table(name = "st_student")
public class StudentDTO extends BaseDTO {

	@Column(name = "enroll_no", length = 20)
	private String enrollNo;

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "phone_no", length = 15)
	private String phoneNo;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "college_id")
	private Long collegeId;

	@Column(name = "college_name", length = 50)
	private String collegeName;

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

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniqueKey() {
		return "enrollNo";
	}

	public String getUniqueValue() {
		return enrollNo;
	}

	public String getLabel() {
		return "Enroll No.";
	}

	@Override
	public String getValue() {
		return firstName+" "+lastName;
	}

	@Override
	public String getTableName() {
		return "Student";
	}
}