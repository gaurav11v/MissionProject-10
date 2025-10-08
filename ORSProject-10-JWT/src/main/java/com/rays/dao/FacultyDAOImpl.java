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
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

@Repository
public class FacultyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt {

	public Class<FacultyDTO> getDTOClass() {
		return FacultyDTO.class;
	}

	protected List<Predicate> getWhereClause(FacultyDTO dto, CriteriaBuilder builder, Root<FacultyDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFirstName())) {
			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName()));
		}
		if (!isEmptyString(dto.getLastName())) {
			whereCondition.add(builder.like(qRoot.get("lastName"), dto.getLastName()));
		}
		if (!isEmptyString(dto.getEmail())) {
			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail()));
		}

		return whereCondition;
	}

	@Autowired
	CollegeDAOInt collegeData = null;

	@Autowired
	CourseDAOInt courseData = null;

	@Autowired
	SubjectDAOInt subjectData = null;

	@Override
	protected void populate(FacultyDTO dto, UserContext userContext) {

		CollegeDTO collegeDto = collegeData.findByPK(dto.getCollegeId(), userContext);
		CourseDTO courseDto = courseData.findByPK(dto.getCourseId(), userContext);
		SubjectDTO subjectDto = subjectData.findByPK(dto.getSubjectId(), userContext);

		if (collegeDto != null) {
			dto.setCollegeName(collegeDto.getName());
		}
		if (courseDto != null) {
			dto.setCourseName(courseDto.getName());
		}
		if (subjectDto != null) {
			dto.setSubjectName(subjectDto.getName());
		}

	}

}
