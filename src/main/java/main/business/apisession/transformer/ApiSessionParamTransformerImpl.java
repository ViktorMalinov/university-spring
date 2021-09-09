package main.business.apisession.transformer;

import main.business.apisession.validator.ApiSessionParamValidatorImpl;
import main.business.common.BaseParamTransformerImpl;
import main.dataaccess.apisession.dao.ApiSession;
import main.service.apisession.ApiSessionParam;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionParamTransformerImpl
		extends BaseParamTransformerImpl<ApiSessionParam, ApiSession, ApiSessionParamValidatorImpl>
		implements ApiSessionParamTransformer {

	/*
	public ApiSessionParamTransformerImpl() {
		this.validator = new ApiSessionParamValidatorImpl();
	}
	*/
	
	@Override
	protected ApiSession getNewEntity() {
		ApiSession entity = new ApiSession();
		return entity;
	}

	@Override
	protected void setProperties(ApiSession entity, ApiSessionParam param) {
		entity.setAuthToken(param.getAuthToken());
	}

}
