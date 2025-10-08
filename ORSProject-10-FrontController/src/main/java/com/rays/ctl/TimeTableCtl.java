package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimeTableDTO;
import com.rays.form.TimeTableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimeTableServiceInt;

@RestController
@RequestMapping("TimeTable")
public class TimeTableCtl extends BaseCtl<TimeTableForm, TimeTableDTO, TimeTableServiceInt> {

	@Autowired
	CourseServiceInt courseService = null;

	@Autowired
	SubjectServiceInt subjectservice = null;

	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		CourseDTO courseDto = new CourseDTO();
		SubjectDTO subjectDto = new SubjectDTO();
		// dto.setStatus(RoleDTO.ACTIVE);
		List<DropdownList> courseList = courseService.search(courseDto, userContext);
		List<DropdownList> subjectList = subjectservice.search(subjectDto, userContext);
		res.addResult("courseList", courseList);
		res.addResult("subjectList", subjectList);
		return res;
	}

}
