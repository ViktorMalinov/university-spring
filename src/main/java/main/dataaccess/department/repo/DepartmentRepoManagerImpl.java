package main.dataaccess.department.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import main.common.Utils;
import main.dataaccess.common.PersistentRepoManagerImpl;
import main.dataaccess.department.dao.Department;

public class DepartmentRepoManagerImpl extends PersistentRepoManagerImpl<Department> implements DepartmentRepoManager {

	
	//private static Map<Long, Department> datasource = new HashMap<Long, Department>();
	
	@Autowired
	private CrudRepository<Department, Long> datasource;
	
	
	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\Department.json"; 
		
		return file;

	}
	
	
	@Override
	public CrudRepository<Department, Long> getDataSource() {
		
		return datasource;
		
	}

	@Override
	public Class<?> getClazz() {
		return Department.class;
	}


}
