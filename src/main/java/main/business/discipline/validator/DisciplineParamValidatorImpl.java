package main.business.discipline.validator;

import org.springframework.stereotype.Component;

import main.business.common.BaseParamValidatorImpl;
import main.service.discipline.DisciplineParam;

@Component
public class DisciplineParamValidatorImpl extends BaseParamValidatorImpl <DisciplineParam> implements DisciplineParamValidator{

	@Override
	public void customValidate(DisciplineParam param) throws Exception {
	}


}
