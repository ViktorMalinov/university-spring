package main.business.apisession.processor;


import main.business.apisession.transformer.ApiSessionParamTransformerImpl;
import main.business.apisession.transformer.ApiSessionResultTransformerImpl;
import main.business.common.BaseProcessorImpl;
import main.dataaccess.apisession.dao.ApiSession;
import main.dataaccess.apisession.dao.ApiSessionDaoImpl;
import main.service.apisession.ApiSessionParam;
import main.service.apisession.ApiSessionResult;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionProcessorImpl
		extends BaseProcessorImpl<
		ApiSessionParam,
		ApiSessionResult,
		ApiSession,
		ApiSessionDaoImpl,
		ApiSessionParamTransformerImpl,
		ApiSessionResultTransformerImpl,
		Long >
		implements ApiSessionProcessor {
	

}
