package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimeTableDTO;

@Repository
public class TimeTableDAOImpl extends BaseDAOImpl<TimeTableDTO> implements TimeTableDAOInt {

	public Class<TimeTableDTO> getDTOClass() {
		return TimeTableDTO.class;
	}

	protected List<Predicate> getWhereClause(TimeTableDTO dto, CriteriaBuilder builder, Root<TimeTableDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getCourseName())) {
			whereCondition.add(builder.like(qRoot.get("courseName"), "%"+dto.getCourseName().toLowerCase()+"%"));
		}
		if (!isEmptyString(dto.getSubjectName())) {
			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName()));
		}
		if (!isEmptyString(dto.getDescription())) {
			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription()));
		}
		System.out.println(">>> Inside getWhereClause, courseName = " + dto.getCourseName());

		return whereCondition;
	}

	@Autowired
	CourseDAOInt courseData = null;

	@Autowired
	SubjectDAOInt subjectData = null;

	protected void populate(TimeTableDTO dto, UserContext userContext) {

		CourseDTO courseDto = courseData.findByPK(dto.getCourseId(), userContext);
		SubjectDTO subjectDto = subjectData.findByPK(dto.getSubjectId(), userContext);
		if (courseDto != null && isEmptyString(dto.getCourseName())) {
			dto.setCourseName(courseDto.getName());
		}
		if (subjectDto != null) {
			dto.setSubjectName(subjectDto.getName());
		}

	}

}
