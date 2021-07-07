package main.business.faculty.processor;

import main.business.common.BaseProcessorImpl;
import main.business.faculty.transformer.FacultyParamTransformerImpl;
import main.business.faculty.transformer.FacultyResultTransformerImpl;
import main.dataaccess.faculty.dao.Faculty;
import main.dataaccess.faculty.dao.FacultyDaoImpl;
import main.service.faculty.FacultyParam;
import main.service.faculty.FacultyResult;

public class FacultyProcessorImpl 
		extends BaseProcessorImpl<
		FacultyParam,
		FacultyResult,
		Faculty,
		FacultyDaoImpl,
		FacultyParamTransformerImpl,
		FacultyResultTransformerImpl,
		Long >
		implements FacultyProcessor {

	/*
	public FacultyProcessorImpl() {
		this.dao = new FacultyDaoImpl();
		this.paramTransformer = new FacultyParamTransformerImpl();
		this.resultTransformer = new FacultyResultTransformerImpl();
	}
	*/
}
