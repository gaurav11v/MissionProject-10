package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.FacultyForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.CourseServiceInt;
import com.rays.service.FacultyServiceInt;
import com.rays.service.SubjectServiceInt;

@RestController
@RequestMapping("Faculty")
public class FacultyCtl extends BaseCtl<FacultyForm, FacultyDTO, FacultyServiceInt> {

	@Autowired
	CollegeServiceInt collegeService = null;

	@Autowired
	CourseServiceInt courseService = null;

	@Autowired
	SubjectServiceInt subjectService = null;

	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		CollegeDTO collegeDto = new CollegeDTO();
		CourseDTO courseDto = new CourseDTO();
		SubjectDTO subjectDto = new SubjectDTO();
		// dto.setStatus(RoleDTO.ACTIVE);
		List<DropdownList> collegeList = collegeService.search(collegeDto, userContext);
		List<DropdownList> courseList = courseService.search(courseDto, userContext);
		List<DropdownList> subjectList = subjectService.search(subjectDto, userContext);
		res.addResult("collegeList", collegeList);
		res.addResult("courseList", courseList);
		res.addResult("subjectList", subjectList);
		return res;
	}

}
