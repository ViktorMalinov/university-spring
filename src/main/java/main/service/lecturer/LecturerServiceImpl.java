package main.service.lecturer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.lecturer.processor.LecturerProcessor;
import main.service.common.BaseServiceImpl;

@Controller
@RequestMapping(value = "/lecturer", produces = "application/json", consumes = "application/json")
public class LecturerServiceImpl 
extends BaseServiceImpl<
LecturerParam,
LecturerResult,
LecturerProcessor,
Long>
implements LecturerService {

	/*
	public LecturerServiceImpl() {
		this.processor = new LecturerProcessorImpl();
	}
	*/
	
}
