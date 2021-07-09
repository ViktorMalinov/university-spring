package main.dataaccess.apigroup.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.apigroup.repo.ApiGroupRepoManager;
import main.dataaccess.common.BaseDaoImpl;

@Component
public class ApiGroupDaoImpl extends BaseDaoImpl <Long, ApiGroup, ApiGroupRepoManager> implements ApiGroupDao {

	/*
	public ApiGroupDaoHMapImpl() {
		this.repoManager = new ApiGroupRepoManagerImpl();
	}
	*/
}
