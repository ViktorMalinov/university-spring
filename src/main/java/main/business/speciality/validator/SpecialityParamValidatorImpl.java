package main.business.speciality.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.business.common.BaseParamValidatorImpl;
import main.common.Constants;
import main.common.ErrCode;
import main.common.UniversityBaseException;
import main.dataaccess.faculty.dao.Faculty;
import main.dataaccess.faculty.dao.FacultyDao;
import main.service.speciality.SpecialityParam;

@Component
public class SpecialityParamValidatorImpl extends BaseParamValidatorImpl <SpecialityParam> implements SpecialityParamValidator{

	@Autowired
	private FacultyDao dao; // = new FacultyDaoImpl();
	
	@Override
	public void customValidate(SpecialityParam param) throws Exception {

		if (param.getFacultyId() == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Faculty ID","Speciality")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}

		Faculty faculty = dao.get(param.getFacultyId());
		
		if (faculty == null) {
			throw new UniversityBaseException( String.format(Constants.NULLOBJECTMESSAGEFORMATTED, "Faculty","Speciality")
					  + " ----> [ " + this.toString() + " ]", 
					ErrCode.NULLOBJECT );
		}
		
		
	}

}
