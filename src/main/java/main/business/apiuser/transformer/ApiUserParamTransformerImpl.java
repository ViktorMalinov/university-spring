package main.business.apiuser.transformer;

import org.springframework.stereotype.Component;

import main.business.apiuser.validator.ApiUserParamValidatorImpl;
import main.business.common.BaseParamTransformerImpl;
import main.dataaccess.apiuser.dao.ApiUser;
import main.service.apiuser.ApiUserParam;

@Component
public class ApiUserParamTransformerImpl 
		extends BaseParamTransformerImpl<ApiUserParam, ApiUser, ApiUserParamValidatorImpl>
		implements ApiUserParamTransformer {

	/*
	public ApiUserParamTransformerImpl() {
		this.validator = new ApiUserParamValidatorImpl();
	}
	*/
	
	@Override
	protected ApiUser getNewEntity() {
		ApiUser entity = new ApiUser();
		return entity;
	}

	@Override
	protected void setProperties(ApiUser entity, ApiUserParam param) {
		entity.setDisplayName(param.getDisplayName());
		entity.setEmail(param.getEmail());
		entity.setPassword(param.getPassword());		
		entity.setUsername(param.getUsername());
	}

}
