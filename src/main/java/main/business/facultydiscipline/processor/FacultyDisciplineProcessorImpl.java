package main.business.facultydiscipline.processor;

import org.springframework.stereotype.Component;

import main.business.common.BaseDtoProcessorImpl;
import main.business.facultydiscipline.transformer.FacultyDisciplineParamTransformerImpl;
import main.business.facultydiscipline.transformer.FacultyDisciplineResultTransformerImpl;
import main.dataaccess.facultydiscipline.dao.FacultyDiscipline;
import main.dataaccess.facultydiscipline.dao.FacultyDisciplineDaoImpl;
import main.service.facultydiscipline.FacultyDisciplineParam;
import main.service.facultydiscipline.FacultyDisciplineResult;

@Component
public class FacultyDisciplineProcessorImpl 
		extends BaseDtoProcessorImpl<
		FacultyDisciplineParam,
		FacultyDisciplineResult,
		FacultyDiscipline,
		FacultyDisciplineDaoImpl,
		FacultyDisciplineParamTransformerImpl,
		FacultyDisciplineResultTransformerImpl,
		Long >
		implements FacultyDisciplineProcessor {

	/*
	public FacultyDisciplineProcessorImpl() {
		this.dao = new FacultyDisciplineDaoImpl();
		this.paramTransformer = new FacultyDisciplineParamTransformerImpl();
		this.resultTransformer = new FacultyDisciplineResultTransformerImpl();
	}
	*/
}
