package main.business.apiuser.processor;

import io.swagger.annotations.Api;
import main.business.common.BaseProcessor;
import main.dataaccess.apiuser.dao.ApiUserDao;
import main.service.apiuser.ApiUserParam;
import main.service.apiuser.ApiUserResult;
import org.springframework.beans.factory.annotation.Autowired;

public interface ApiUserProcessor extends BaseProcessor<ApiUserParam, ApiUserResult, Long> {

    public ApiUserResult getUser(String username) throws Exception;

}
