package main.business.apigroup.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseResultTransformerImpl;
import main.dataaccess.apigroup.dao.ApiGroup;
import main.service.apigroup.ApiGroupResult;

@Component
public class ApiGroupResultTransformerImpl 
	extends BaseResultTransformerImpl<ApiGroupResult,ApiGroup> 
	implements ApiGroupResultTransformer {

	@Override
	public ApiGroupResult getNewResult() {
		ApiGroupResult result = new ApiGroupResult();
		return result;
	}
	
	@Override
	protected void setProperties(ApiGroup entity, ApiGroupResult result) {
		result.setDisplayName(entity.getDisplayName());
	}

}
