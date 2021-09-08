package main.dataaccess.apigroup.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.dataaccess.apigroup.dao.ApiGroup;
import main.dataaccess.common.PersistentRepoManagerImpl;

@Repository
public class ApiGroupRepoManagerImpl extends PersistentRepoManagerImpl<ApiGroup> implements ApiGroupRepoManager {

	
	@Autowired
	private ApiGroupCrudRepository datasource;
	
	
	
	@Override
	public CrudRepository<ApiGroup, Long> getDataSource() {
		return datasource;
	}
	
	/*
	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\ApiGroup.json"; 
		
		return file;
	}
	*/

	@Override
	public Class<?> getClazz() {
		return ApiGroup.class;
	}
	
	

}
