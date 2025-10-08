package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_timetable")
public class TimeTableDTO extends BaseDTO {

	@Column(name = "subject_id")
	private Long subjectId;

	@Column(name = "subject_name", length = 50)
	private String subjectName;

	@Column(name = "course_id")
	private Long courseId;

	@Column(name = "course_name", length = 50)
	private String courseName;

	@Column(name = "exam_date")
	private Date examDate;

	@Column(name = "description", length = 50)
	private String description;

	@Column(name = "semester", length = 30)
	private String semester;

	@Column(name = "exam_time", length = 50)
	private String examTime; 

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
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

	public String getUniqueKey() {
		return "subjectName";
	}

	public String getUniqueValue() {
		return subjectName;
	}

	public String getLabel() {
		return "Subject Name";
	}

	public String getValue() {
		return null;
	}

	@Override
	public String getTableName() {
		return "TimeTable";
	}

}