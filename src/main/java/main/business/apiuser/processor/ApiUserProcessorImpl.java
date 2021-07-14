package main.business.apiuser.processor;

import org.springframework.stereotype.Component;

import main.business.apiuser.transformer.ApiUserParamTransformerImpl;
import main.business.apiuser.transformer.ApiUserResultTransformerImpl;
import main.business.common.BaseProcessorImpl;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.apiuser.dao.ApiUserDaoImpl;
import main.service.apiuser.ApiUserParam;
import main.service.apiuser.ApiUserResult;

@Component
public class ApiUserProcessorImpl 
		extends BaseProcessorImpl<
		ApiUserParam,
		ApiUserResult,
		ApiUser,
		ApiUserDaoImpl,
		ApiUserParamTransformerImpl,
		ApiUserResultTransformerImpl,
		Long >
		implements ApiUserProcessor {
	
	/*
	public ApiUserProcessorImpl() {
		this.dao = new ApiUserDaoImpl();
		this.paramTransformer = new ApiUserParamTransformerImpl();
		this.resultTransformer = new ApiUserResultTransformerImpl();
	}
	*/
}
