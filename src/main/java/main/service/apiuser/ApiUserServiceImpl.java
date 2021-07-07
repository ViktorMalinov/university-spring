package main.service.apiuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.business.apiuser.processor.ApiUserProcessor;
import main.service.common.BaseServiceImpl;

@Controller
@RequestMapping(value = "/apiuser", produces = "application/json", consumes = "application/json")
public class ApiUserServiceImpl 
extends BaseServiceImpl<
ApiUserParam,
ApiUserResult,
ApiUserProcessor,
Long>
implements ApiUserService {

	/*
	public ApiUserServiceImpl() {
		this.processor = new ApiUserProcessorImpl();
	}
	*/
}
