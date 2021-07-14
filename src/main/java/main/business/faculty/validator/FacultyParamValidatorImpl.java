package main.business.faculty.validator;

import org.springframework.stereotype.Component;

import main.business.common.BaseParamValidatorImpl;
import main.service.faculty.FacultyParam;

@Component
public class FacultyParamValidatorImpl extends BaseParamValidatorImpl <FacultyParam> implements FacultyParamValidator{

	@Override
	public void customValidate(FacultyParam param) throws Exception {
	}


}
