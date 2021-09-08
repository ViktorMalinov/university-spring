package main.dataaccess.department.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.common.BaseDaoImpl;
import main.dataaccess.department.repo.DepartmentRepoManager;

@Component
public class DepartmentDaoImpl extends BaseDaoImpl <Long, Department, DepartmentRepoManager> implements DepartmentDao {

	/*
	public DepartmentDaoImpl() {
		this.repoManager = new DepartmentRepoManagerImpl();
	}
	*/

}
