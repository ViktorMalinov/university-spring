package main.dataaccess.apiuser.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import main.common.Utils;
import main.dataaccess.apiuser.dao.ApiUser;
import main.dataaccess.common.PersistentRepoManagerImpl;

public class ApiUserRepoManagerImpl extends PersistentRepoManagerImpl<ApiUser> implements ApiUserRepoManager {

	//private static Map<Long, ApiUser> datasource = new HashMap<Long, ApiUser>();

	@Autowired
	private CrudRepository<ApiUser, Long> datasource;

	
	@Override
	public CrudRepository<ApiUser, Long> getDataSource() {
		return datasource;
	}


	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\ApiUser.json"; 
		
		return file;
	}
	
	@Override
	public Class<?> getClazz() {
		return ApiUser.class;
	}

}
