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

@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

	public Class<SubjectDTO> getDTOClass() {
		return SubjectDTO.class;
	}

	protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName()));
		}

		return whereCondition;
	}

	@Autowired
	CourseDAOInt courseData = null;

	protected void populate(SubjectDTO dto, UserContext userContext) {

		CourseDTO courseDto = courseData.findByPK(dto.getCourseId(), userContext);
		
		System.out.println("IN Subjectdaoint course id => "+courseDto.getId());

		if (courseDto != null) {
			dto.setCourseName(courseDto.getName());
		}

	}

}
