package main.business.discipline.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseResultTransformerImpl;
import main.dataaccess.discipline.dao.Discipline;
import main.service.discipline.DisciplineResult;

@Component
public class DisciplineResultTransformerImpl 
		extends BaseResultTransformerImpl<DisciplineResult,Discipline>
		implements DisciplineResultTransformer {

	@Override
	public DisciplineResult getNewResult() {
		DisciplineResult result = new DisciplineResult();
		return result;
	}

}
