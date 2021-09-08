package main.dataaccess.apiuser.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.apiuser.repo.ApiUserRepoManager;
import main.dataaccess.common.BaseDaoImpl;

@Component
public class ApiUserDaoImpl extends BaseDaoImpl <Long, ApiUser, ApiUserRepoManager> implements ApiUserDao {

	/*
	public ApiUserDaoImpl() {
		this.repoManager = new ApiUserRepoManagerImpl();
	}
	*/

}
