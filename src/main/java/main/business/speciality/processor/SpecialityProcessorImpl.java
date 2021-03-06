package main.business.speciality.processor;

import org.springframework.stereotype.Component;

import main.business.common.BaseProcessorImpl;
import main.business.speciality.transformer.SpecialityParamTransformerImpl;
import main.business.speciality.transformer.SpecialityResultTransformerImpl;
import main.dataaccess.speciality.dao.Speciality;
import main.dataaccess.speciality.dao.SpecialityDaoImpl;
import main.service.speciality.SpecialityParam;
import main.service.speciality.SpecialityResult;

@Component
public class SpecialityProcessorImpl 
extends BaseProcessorImpl<
SpecialityParam,
SpecialityResult,
Speciality,
SpecialityDaoImpl,
SpecialityParamTransformerImpl,
SpecialityResultTransformerImpl,
Long >
implements SpecialityProcessor {

	/*
	public SpecialityProcessorImpl() {
		this.dao = new SpecialityDaoImpl();
		this.paramTransformer = new SpecialityParamTransformerImpl();
		this.resultTransformer = new SpecialityResultTransformerImpl();
	}
	*/
}
