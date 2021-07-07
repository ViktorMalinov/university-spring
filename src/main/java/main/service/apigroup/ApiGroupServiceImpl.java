package main.service.apigroup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.apigroup.processor.ApiGroupProcessor;
import main.service.common.BaseServiceImpl;

@Controller
@RequestMapping(value = "/apigroup", produces = "application/json", consumes = "application/json")
public class ApiGroupServiceImpl 
extends BaseServiceImpl<
		ApiGroupParam,
		ApiGroupResult,
		ApiGroupProcessor,
		Long>
		implements ApiGroupService {
	
	/*
	public ApiGroupServiceImpl() {
		this.processor = new ApiGroupProcessorImpl();
	}	
	*/
}
