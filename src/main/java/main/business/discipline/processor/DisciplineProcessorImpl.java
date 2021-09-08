package main.business.discipline.processor;

import org.springframework.stereotype.Component;

import main.business.common.BaseProcessorImpl;
import main.business.discipline.transformer.DisciplineParamTransformerImpl;
import main.business.discipline.transformer.DisciplineResultTransformerImpl;
import main.dataaccess.discipline.dao.Discipline;
import main.dataaccess.discipline.dao.DisciplineDaoImpl;
import main.service.discipline.DisciplineParam;
import main.service.discipline.DisciplineResult;

@Component
public class DisciplineProcessorImpl 
		extends BaseProcessorImpl<
		DisciplineParam,
		DisciplineResult,
		Discipline,
		DisciplineDaoImpl,
		DisciplineParamTransformerImpl,
		DisciplineResultTransformerImpl,
		Long >
		implements DisciplineProcessor {
	
	/*
	public DisciplineProcessorImpl() {
		this.dao = new DisciplineDaoImpl();
		this.paramTransformer = new DisciplineParamTransformerImpl();
		this.resultTransformer = new DisciplineResultTransformerImpl();
	}
	*/
}
