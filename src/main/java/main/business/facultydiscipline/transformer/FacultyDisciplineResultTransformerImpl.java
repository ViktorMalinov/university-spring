package main.business.facultydiscipline.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseDtoResultTransformerImpl;
import main.common.Constants;
import main.common.ErrCode;
import main.common.UniversityBaseException;
import main.dataaccess.facultydiscipline.dao.FacultyDiscipline;
import main.service.facultydiscipline.FacultyDisciplineResult;

@Component
public class FacultyDisciplineResultTransformerImpl 
		extends BaseDtoResultTransformerImpl<FacultyDisciplineResult,FacultyDiscipline> 
		implements FacultyDisciplineResultTransformer {

	@Override
	public FacultyDisciplineResult getNewResult() {
		FacultyDisciplineResult result = new FacultyDisciplineResult();
		return result;
	}
	
	@Override
	protected void setProperties(FacultyDiscipline entity, FacultyDisciplineResult result) throws Exception {

		if (entity.getDiscipline() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Discipline","Faculty Discipline")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
			
		}
		
		if (entity.getDiscipline().getName() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Discipline name","Discipline")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		if (entity.getFaculty() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Faculty","Faculty Discipline")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		if (entity.getFaculty().getName() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Faculty name","Faculty")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
				
		result.setDisciplineId(entity.getDiscipline().getId());
		result.setDisciplineName(entity.getDiscipline().getName());
		
		result.setFacultyId(entity.getFaculty().getId());
		result.setFacultyName(entity.getFaculty().getName());
	
	}

}
