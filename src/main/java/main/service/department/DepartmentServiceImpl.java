package main.service.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.department.processor.DepartmentProcessor;
import main.service.common.BaseServiceImpl;

@Controller
@RequestMapping(value = "/department", produces = "application/json", consumes = "application/json")
public class DepartmentServiceImpl 
		extends BaseServiceImpl<
		DepartmentParam,
		DepartmentResult,
		DepartmentProcessor,
		Long>
		implements DepartmentService {

	/*
	public DepartmentServiceImpl() {
		this.processor = new DepartmentProcessorImpl();
	}
	*/
	
}
