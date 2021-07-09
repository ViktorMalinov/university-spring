package main.business.apigroup.validator;

import org.springframework.stereotype.Component;

import main.business.common.BaseParamValidatorImpl;
import main.service.apigroup.ApiGroupParam;

@Component
public class ApiGroupParamValidatorImpl extends BaseParamValidatorImpl<ApiGroupParam> implements ApiGroupParamValidator{

	@Override
	public void customValidate(ApiGroupParam param) throws Exception {
	}

}
