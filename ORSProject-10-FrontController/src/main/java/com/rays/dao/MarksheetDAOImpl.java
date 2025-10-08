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
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;

@Repository
public class MarksheetDAOImpl extends BaseDAOImpl<MarksheetDTO> implements MarksheetDAOInt {

	public Class<MarksheetDTO> getDTOClass() {
		return MarksheetDTO.class;
	}

	protected List<Predicate> getWhereClause(MarksheetDTO dto, CriteriaBuilder builder, Root<MarksheetDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), "%"+dto.getName()+"%"));
		}
		if (!isEmptyString(dto.getRollNo())) {
			whereCondition.add(builder.like(qRoot.get("rollNo"), dto.getRollNo()));
		}
		return whereCondition;
	}

	@Autowired
	StudentDAOInt studentData = null;

	@Override
	protected void populate(MarksheetDTO dto, UserContext userContext) {

		StudentDTO studentDto = studentData.findByPK(dto.getStudentId(), userContext);

		if (studentDto != null) {
			dto.setName(studentDto.getFirstName() + " " + studentDto.getLastName());
		}

	}

}
