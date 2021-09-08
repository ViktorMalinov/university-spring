package main.business.speciality.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseResultTransformerImpl;
import main.common.Constants;
import main.common.ErrCode;
import main.common.UniversityBaseException;
import main.dataaccess.speciality.dao.Speciality;
import main.service.speciality.SpecialityResult;

@Component
public class SpecialityResultTransformerImpl 
extends BaseResultTransformerImpl<SpecialityResult,Speciality>
implements SpecialityResultTransformer {


	@Override
	public SpecialityResult getNewResult() {
		SpecialityResult result = new SpecialityResult();
		return result;
	}
	
	@Override
	protected void setProperties(Speciality entity, SpecialityResult result) throws Exception {

		if (entity.getFaculty() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Faculty","Speciality")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		if (entity.getFaculty().getName().isEmpty()) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Faculty name","Faculty")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}

		result.setFacultyId(entity.getFaculty().getId());
		result.setFacultyName(entity.getFaculty().getName());
	}

}
