package main.service.speciality;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.speciality.processor.SpecialityProcessor;
import main.service.common.BaseServiceImpl;

@Controller
@RequestMapping(value = "/speciality", produces = "application/json", consumes = "application/json")
public class SpecialityServiceImpl 
		extends BaseServiceImpl<
		SpecialityParam,
		SpecialityResult,
		SpecialityProcessor,
		Long>
		implements SpecialityService {

	/*
	public SpecialityServiceImpl() {
		this.processor = new SpecialityProcessorImpl();
	}
	*/
}
