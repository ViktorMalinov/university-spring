package main.business.apigroupuser.validator;

import org.springframework.beans.factory.annotation.Autowired;

import main.business.common.BaseParamValidatorImpl;
import main.common.Constants;
import main.common.ErrCode;
import main.common.UniversityBaseException;
import main.dataaccess.apigroup.dao.ApiGroup;
import main.dataaccess.apigroup.dao.ApiGroupDao;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.apiuser.dao.ApiUserDao;
import main.service.apigroupuser.ApiGroupUserParam;

public class ApiGroupUserParamValidatorImpl extends BaseParamValidatorImpl <ApiGroupUserParam> implements ApiGroupUserParamValidator{

	@Autowired
	ApiGroupDao	apiGroupDao; // = new ApiGroupDaoImpl();
	
	@Autowired
	ApiUserDao apiUserDao; // = new ApiUserDaoImpl();
	
	@Override
	public void customValidate(ApiGroupUserParam param) throws Exception {
		
		if (param.getApiGroupId() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api group ID","Api group user")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}		

		if (param.getApiUserId() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api user ID","Api group user")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}		

		ApiGroup apiGroup = apiGroupDao.get(param.getApiGroupId());
		ApiUser apiUser = apiUserDao.get(param.getApiUserId());

		
		if (apiGroup == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api group","Api group user")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		if (apiUser == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Api user","Api group user")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		

	}

}
