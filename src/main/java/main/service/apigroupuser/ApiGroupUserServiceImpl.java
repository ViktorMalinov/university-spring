package main.service.apigroupuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.apigroupuser.processor.ApiGroupUserProcessor;
import main.service.common.BaseDtoServiceImpl;

@Controller
@RequestMapping(value = "/apigroupuser", produces = "application/json", consumes = "application/json")
public class ApiGroupUserServiceImpl 
		extends BaseDtoServiceImpl<
		ApiGroupUserParam,
		ApiGroupUserResult,
		ApiGroupUserProcessor,
		Long>
		implements ApiGroupUserService {

	/*
	public ApiGroupUserServiceImpl() {
		this.processor = new ApiGroupUserProcessorImpl();
	}
	*/
	
	
}
