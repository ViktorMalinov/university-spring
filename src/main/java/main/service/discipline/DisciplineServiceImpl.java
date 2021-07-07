package main.service.discipline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.discipline.processor.DisciplineProcessor;
import main.service.common.BaseServiceImpl;

@Controller
@RequestMapping(value = "/discipline", produces = "application/json", consumes = "application/json")
public class DisciplineServiceImpl 
extends BaseServiceImpl<
		DisciplineParam,
		DisciplineResult,
		DisciplineProcessor,
		Long>
		implements DisciplineService {

	/*
	public DisciplineServiceImpl() {
		this.processor = new DisciplineProcessorImpl();
	}
	*/

}
