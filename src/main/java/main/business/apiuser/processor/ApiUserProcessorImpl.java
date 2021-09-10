package main.business.apiuser.processor;

import main.business.apiuser.transformer.ApiUserResultTransformer;
import main.dataaccess.apiuser.dao.ApiUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.business.apiuser.transformer.ApiUserParamTransformerImpl;
import main.business.apiuser.transformer.ApiUserResultTransformerImpl;
import main.business.common.BaseProcessorImpl;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.apiuser.dao.ApiUserDaoImpl;
import main.service.apiuser.ApiUserParam;
import main.service.apiuser.ApiUserResult;

@Component
public class ApiUserProcessorImpl 
		extends BaseProcessorImpl<
		ApiUserParam,
		ApiUserResult,
		ApiUser,
		ApiUserDaoImpl,
		ApiUserParamTransformerImpl,
		ApiUserResultTransformerImpl,
		Long >
		implements ApiUserProcessor {

	@Autowired
	private ApiUserDao apiUserDao;

	@Autowired
	private ApiUserResultTransformer apiUserResultTransformer;


	@Override
	public ApiUserResult getUser(String username) throws Exception {
		return apiUserResultTransformer.transform(apiUserDao.getUser(username));
	}
}
