package main.dataaccess.apigroup.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import main.common.Utils;
import main.dataaccess.apigroup.dao.ApiGroup;
import main.dataaccess.common.PersistentRepoManagerImpl;

public class ApiGroupRepoManagerImpl extends PersistentRepoManagerImpl<ApiGroup> implements ApiGroupRepoManager {


	@Autowired
	private CrudRepository<ApiGroup, Long> datasource;
	
	
	@Override
	public CrudRepository<ApiGroup, Long> getDataSource() {
		return datasource;
	}

	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\ApiGroup.json"; 
		
		return file;
	}
	

	@Override
	public Class<?> getClazz() {
		return ApiGroup.class;
	}
	
	

}
