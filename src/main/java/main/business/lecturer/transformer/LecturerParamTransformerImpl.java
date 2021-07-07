package main.business.lecturer.transformer;

import org.springframework.beans.factory.annotation.Autowired;

import main.business.common.BaseParamTransformerImpl;
import main.business.lecturer.validator.LecturerParamValidatorImpl;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.apiuser.dao.ApiUserDao;
import main.dataaccess.department.dao.Department;
import main.dataaccess.department.dao.DepartmentDao;
import main.dataaccess.department.dao.DepartmentDaoImpl;
import main.dataaccess.lecturer.dao.Lecturer;
import main.service.lecturer.LecturerParam;

public class LecturerParamTransformerImpl 
extends BaseParamTransformerImpl<LecturerParam, Lecturer, LecturerParamValidatorImpl>
implements LecturerParamTransformer {

	@Autowired
	private ApiUserDao apiUserDao; // = new ApiUserDaoImpl();
	@Autowired
	private DepartmentDao departmentDao = new DepartmentDaoImpl(); 

	/*
	public LecturerParamTransformerImpl() {
		this.validator = new LecturerParamValidatorImpl();
	}
	*/
	
	@Override
	protected Lecturer getNewEntity() {
		Lecturer entity = new Lecturer();
		return entity;
	}

	protected void setProperties(Lecturer entity, LecturerParam param) {
		Department department = departmentDao.get(param.getDepartmentId());
		ApiUser apiUser = apiUserDao.get(param.getApiUserId());
		
		entity.setApiUser(apiUser);
		entity.setDepartment(department);

		entity.setFamilyName(param.getFamilyName());
	}
}
