package main.dataaccess.apigroupuser.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.common.Utils;
import main.dataaccess.apigroupuser.dao.ApiGroupUser;
import main.dataaccess.common.PersistentRepoManagerImpl;

@Repository
public class ApiGroupUserRepoManagerImpl extends PersistentRepoManagerImpl<ApiGroupUser> implements ApiGroupUserRepoManager {

	//private static Map<Long, ApiGroupUser> datasource = new HashMap<Long, ApiGroupUser>();

	@Autowired
	private ApiGroupUserCrudRepository datasource;
	
	
	@Override
	public CrudRepository<ApiGroupUser, Long> getDataSource() {
		return datasource;
	}

	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\ApiGroupUser.json"; 
		
		return file;
	}

	@Override
	public Class<?> getClazz() {
		return ApiGroupUser.class;
	}


	
}
