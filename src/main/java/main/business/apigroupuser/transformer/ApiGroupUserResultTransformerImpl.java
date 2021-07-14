package main.business.apigroupuser.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseDtoResultTransformerImpl;
import main.common.Constants;
import main.common.ErrCode;
import main.common.UniversityBaseException;
import main.dataaccess.apigroupuser.dao.ApiGroupUser;
import main.service.apigroupuser.ApiGroupUserResult;

@Component
public class ApiGroupUserResultTransformerImpl 
		extends BaseDtoResultTransformerImpl<ApiGroupUserResult,ApiGroupUser> 
		implements ApiGroupUserResultTransformer {


	@Override
	public ApiGroupUserResult getNewResult() {
		ApiGroupUserResult result = new ApiGroupUserResult();
		return result;
	}
	
	@Override
	protected void setProperties(ApiGroupUser entity, ApiGroupUserResult result) throws Exception {
		
		if (entity.getApiGroup() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api group","Api group user")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		if (entity.getApiGroup().getDisplayName() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api group display name","Api group")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		if (entity.getApiUser() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api user","Api group user")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		if (entity.getApiUser().getDisplayName() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api user display name","Api user")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		result.setApiGroupId(entity.getApiGroup().getId());
		result.setApiGroupDisplayName(entity.getApiGroup().getDisplayName());
		
		result.setApiUserId(entity.getApiUser().getId());
		result.setApiUserDisplayName(entity.getApiUser().getDisplayName());

	
	}

}
