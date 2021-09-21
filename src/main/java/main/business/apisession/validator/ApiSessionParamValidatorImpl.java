package main.business.apisession.validator;

import main.business.common.BaseParamValidatorImpl;
import main.dataaccess.apisession.dao.ApiSession;
import main.service.apisession.ApiSessionParam;
import main.service.apiuser.ApiUserParam;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionParamValidatorImpl extends BaseParamValidatorImpl <ApiSessionParam> implements ApiSessionParamValidator {

	@Override
	public void customValidate(ApiSessionParam param) throws Exception {
	}


}
