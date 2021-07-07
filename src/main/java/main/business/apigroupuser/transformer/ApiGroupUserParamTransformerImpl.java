package main.business.apigroupuser.transformer;

import org.springframework.beans.factory.annotation.Autowired;

import main.business.apigroupuser.validator.ApiGroupUserParamValidatorImpl;
import main.business.common.BaseDtoParamTransformerImpl;
import main.dataaccess.apigroup.dao.ApiGroup;
import main.dataaccess.apigroup.dao.ApiGroupDao;
import main.dataaccess.apigroupuser.dao.ApiGroupUser;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.apiuser.dao.ApiUserDao;
import main.service.apigroupuser.ApiGroupUserParam;

public class ApiGroupUserParamTransformerImpl 
		extends BaseDtoParamTransformerImpl<ApiGroupUserParam, ApiGroupUser, ApiGroupUserParamValidatorImpl>
		implements ApiGroupUserParamTransformer {


	@Autowired
	private ApiGroupDao	apiGroupDao; // = new ApiGroupDaoImpl();
	
	@Autowired
	private ApiUserDao apiUserDao; // = new ApiUserDaoImpl();

	/*
	public ApiGroupUserParamTransformerImpl() {
		this.validator = new ApiGroupUserParamValidatorImpl();
	}
	*/
	
	@Override
	protected ApiGroupUser getNewEntity() {
		ApiGroupUser entity = new ApiGroupUser();
		return entity;
	}

	protected void setProperties(ApiGroupUser entity, ApiGroupUserParam param) {

		ApiGroup apiGroup = apiGroupDao.get(param.getApiGroupId());
		ApiUser apiUser = apiUserDao.get(param.getApiUserId());
		
		entity.setApiGroup(apiGroup);
		entity.setApiUser(apiUser);

		//entity.setId(param.getId());

	}

}
