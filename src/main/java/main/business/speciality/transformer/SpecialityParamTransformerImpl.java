package main.business.speciality.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.business.common.BaseParamTransformerImpl;
import main.business.speciality.validator.SpecialityParamValidatorImpl;
import main.dataaccess.faculty.dao.Faculty;
import main.dataaccess.faculty.dao.FacultyDao;
import main.dataaccess.speciality.dao.Speciality;
import main.service.speciality.SpecialityParam;

@Component
public class SpecialityParamTransformerImpl 
extends BaseParamTransformerImpl<SpecialityParam, Speciality, SpecialityParamValidatorImpl>
implements SpecialityParamTransformer {

	@Autowired
	private FacultyDao dao; // = new FacultyDaoImpl();
	
	/*
	public SpecialityParamTransformerImpl() {
		this.validator = new SpecialityParamValidatorImpl();
	}
	*/
	
	@Override
	protected Speciality getNewEntity() {
		Speciality entity = new Speciality();
		return entity;
	}

	@Override
	protected void setProperties(Speciality entity, SpecialityParam param) {
		Faculty faculty = dao.get(param.getFacultyId());
		entity.setFaculty(faculty);
	}


}
