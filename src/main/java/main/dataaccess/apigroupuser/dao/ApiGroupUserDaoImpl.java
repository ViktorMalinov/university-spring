package main.dataaccess.apigroupuser.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.apigroupuser.repo.ApiGroupUserRepoManager;
import main.dataaccess.common.BaseDaoImpl;

@Component
public class ApiGroupUserDaoImpl  extends BaseDaoImpl<Long, ApiGroupUser, ApiGroupUserRepoManager> implements ApiGroupUserDao {

	/*
	public ApiGroupUserDaoImpl() {
		this.repoManager = new ApiGroupUserRepoManagerImpl();
	}
	*/

}
