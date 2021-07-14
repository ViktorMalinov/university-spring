package main.business.apiuser.validator;

import org.springframework.stereotype.Component;

import main.business.common.BaseParamValidatorImpl;
import main.service.apiuser.ApiUserParam;

@Component
public class ApiUserParamValidatorImpl extends BaseParamValidatorImpl <ApiUserParam> implements ApiUserParamValidator{

	@Override
	public void customValidate(ApiUserParam param) throws Exception {
	}


}
