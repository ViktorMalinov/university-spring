package main.business.apiuser.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseResultTransformerImpl;
import main.dataaccess.apiuser.dao.ApiUser;
import main.service.apiuser.ApiUserResult;

@Component
public class ApiUserResultTransformerImpl 
		extends BaseResultTransformerImpl<ApiUserResult, ApiUser>
		implements ApiUserResultTransformer {

	
	@Override
	public ApiUserResult getNewResult() {
		ApiUserResult result = new ApiUserResult();
		return result;
	}
	
	@Override
	protected void setProperties(ApiUser entity, ApiUserResult result) {
		result.setDisplayName(entity.getDisplayName());
		result.setEmail(entity.getEmail());
		result.setPassword(entity.getPassword());		
		result.setUsername(entity.getUsername());
	}
	
}
