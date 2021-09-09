package main.business.apisession.transformer;

import main.business.common.BaseResultTransformerImpl;
import main.dataaccess.apisession.dao.ApiSession;
import main.service.apisession.ApiSessionResult;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionResultTransformerImpl
		extends BaseResultTransformerImpl<ApiSessionResult, ApiSession>
		implements ApiSessionResultTransformer {

	
	@Override
	public ApiSessionResult getNewResult() {
		ApiSessionResult result = new ApiSessionResult();
		return result;
	}
	
	@Override
	protected void setProperties(ApiSession entity, ApiSessionResult result) {
		result.setAuthToken(entity.getAuthToken());
	}
	
}
