package main.business.apisession.validator;

import main.common.Validator;
import main.service.apisession.ApiSessionParam;
import main.service.apiuser.ApiUserParam;

public interface ApiSessionParamValidator extends Validator<ApiSessionParam> {
	
	public void validate(ApiSessionParam param) throws Exception;

}
