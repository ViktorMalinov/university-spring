package main.business.faculty.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseResultTransformerImpl;
import main.dataaccess.faculty.dao.Faculty;
import main.service.faculty.FacultyResult;

@Component
public class FacultyResultTransformerImpl 
extends BaseResultTransformerImpl<FacultyResult,Faculty>
implements FacultyResultTransformer {

	@Override
	public FacultyResult getNewResult() {
		FacultyResult result = new FacultyResult();
		return result;
	}
}
