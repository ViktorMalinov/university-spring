package main.business.apigroup.processor;

import org.springframework.stereotype.Component;

import main.business.apigroup.transformer.ApiGroupParamTransformerImpl;
import main.business.apigroup.transformer.ApiGroupResultTransformerImpl;
import main.business.common.BaseProcessorImpl;
import main.dataaccess.apigroup.dao.ApiGroup;
import main.dataaccess.apigroup.dao.ApiGroupDaoImpl;
import main.service.apigroup.ApiGroupParam;
import main.service.apigroup.ApiGroupResult;

@Component
public class ApiGroupProcessorImpl 
	extends BaseProcessorImpl<
	ApiGroupParam,
	ApiGroupResult,
	ApiGroup,
	ApiGroupDaoImpl,
	ApiGroupParamTransformerImpl,
	ApiGroupResultTransformerImpl,
	Long >
	implements ApiGroupProcessor {

	/*
	public ApiGroupProcessorImpl() {
		this.dao = new ApiGroupDaoHMapImpl();
		this.paramTransformer = new ApiGroupParamTransformerImpl();
		this.resultTransformer = new ApiGroupResultTransformerImpl();
	}
	*/

}
