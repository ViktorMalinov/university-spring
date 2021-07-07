package main.service.facultydiscipline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.facultydiscipline.processor.FacultyDisciplineProcessor;
import main.service.common.BaseDtoServiceImpl;

@Controller
@RequestMapping(value = "/facultydiscipline", produces = "application/json", consumes = "application/json")
public class FacultyDisciplineServiceImpl 
		extends BaseDtoServiceImpl<
		FacultyDisciplineParam,
		FacultyDisciplineResult,
		FacultyDisciplineProcessor,
		Long>
implements FacultyDisciplineService {

	/*
	public FacultyDisciplineServiceImpl() {
		this.processor = new FacultyDisciplineProcessorImpl();
	}
	*/

}
