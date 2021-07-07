package main.service.faculty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.faculty.processor.FacultyProcessor;
import main.service.common.BaseServiceImpl;

@Controller
@RequestMapping(value = "/faculty", produces = "application/json", consumes = "application/json")
public class FacultyServiceImpl 
extends BaseServiceImpl<
		FacultyParam,
		FacultyResult,
		FacultyProcessor,
		Long>
		implements FacultyService {

	/*
	public FacultyServiceImpl() {
		this.processor = new FacultyProcessorImpl();
	}
	*/
}
