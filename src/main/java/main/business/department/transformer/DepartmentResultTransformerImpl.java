package main.business.department.transformer;

import org.springframework.stereotype.Component;

import main.business.common.BaseResultTransformerImpl;
import main.dataaccess.department.dao.Department;
import main.service.department.DepartmentResult;

@Component
public class DepartmentResultTransformerImpl 
		extends BaseResultTransformerImpl<DepartmentResult,Department> 
		implements DepartmentResultTransformer {

	@Override
	public DepartmentResult getNewResult() {
		DepartmentResult result = new DepartmentResult();
		return result;
	}
	
	@Override
	protected void setProperties(Department entity, DepartmentResult result) {
		result.setFacultyId(entity.getFaculty().getId());
		result.setFacultyName(entity.getFaculty().getName());
	}

}

