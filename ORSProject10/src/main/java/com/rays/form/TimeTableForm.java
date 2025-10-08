package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TimeTableDTO;

public class TimeTableForm extends BaseForm {

	@NotNull(message = "please enter subject id")
	private Long subjectId;
	private String subjectName;
	
	@NotNull(message = "please enter course id")
	private Long courseId;
	private String courseName;

	@NotNull(message = "please enter exam date")
	private Date examDate;

	@NotEmpty(message = "please enter description")
	private String description;

	@NotEmpty(message = "please enter semester")
	private String semester;

	@NotEmpty(message = "please enter examTime")
	private String examTime;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getExamDate() {
		return examDate;
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

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public BaseDTO getDto() {

		TimeTableDTO dto = initDTO(new TimeTableDTO());

		dto.setCourseId(courseId);
		dto.setCourseName(courseName);
		dto.setDescription(description);
		dto.setExamDate(examDate);
		dto.setExamTime(examTime);
		dto.setSemester(semester);
		dto.setSubjectId(subjectId);
		dto.setSubjectName(subjectName);
		System.out.println(">>> Search CourseName from form = " + dto.getCourseName());


		return dto;
	}

}
