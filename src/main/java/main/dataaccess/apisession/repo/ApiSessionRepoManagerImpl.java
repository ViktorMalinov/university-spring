package main.dataaccess.apisession.repo;


import main.dataaccess.apisession.dao.ApiSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.common.Utils;

import main.dataaccess.common.PersistentRepoManagerImpl;

@Repository
public class ApiSessionRepoManagerImpl extends PersistentRepoManagerImpl<ApiSession> implements ApiSessionRepoManager {


	@Autowired
	private ApiSessionCrudRepository datasource;

	
	@Override
	public CrudRepository<ApiSession, Long> getDataSource() {
		return datasource;
	}


	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\ApiSession.json";
		
		return file;
	}
	
	@Override
	public Class<?> getClazz() {
		return ApiSession.class;
	}

}
