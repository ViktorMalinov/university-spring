package main.business.department.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.business.common.BaseParamTransformerImpl;
import main.business.department.validator.DepartmentParamValidatorImpl;
import main.dataaccess.department.dao.Department;
import main.dataaccess.faculty.dao.Faculty;
import main.dataaccess.faculty.dao.FacultyDao;
import main.service.department.DepartmentParam;

@Component
public class DepartmentParamTransformerImpl 
		extends BaseParamTransformerImpl<DepartmentParam, Department, DepartmentParamValidatorImpl> 
		implements DepartmentParamTransformer {

	
	@Autowired
	private FacultyDao dao; // = new FacultyDaoImpl();
	
	/*
	public DepartmentParamTransformerImpl() {
		this.validator = new DepartmentParamValidatorImpl();
	}
	*/
	
	@Override
	protected Department getNewEntity() {
		Department entity = new Department();
		return entity;
	}

	@Override
	protected void setProperties(Department entity, DepartmentParam param) {
		Faculty fResult = dao.get(param.getFacultyId());  
		entity.setFaculty(fResult); 
	}


}
