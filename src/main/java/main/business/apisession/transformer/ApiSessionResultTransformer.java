package main.business.apisession.transformer;

import main.business.common.BaseResultTransformer;
import main.dataaccess.apisession.dao.ApiSession;
import main.service.apisession.ApiSessionResult;

public interface ApiSessionResultTransformer extends BaseResultTransformer<ApiSessionResult, ApiSession> {

}
