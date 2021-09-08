package main.dataaccess.faculty.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.common.BaseDaoImpl;
import main.dataaccess.faculty.repo.FacultyRepoManager;

@Component
public class FacultyDaoImpl extends BaseDaoImpl <Long, Faculty, FacultyRepoManager> implements FacultyDao {

	/*
	public FacultyDaoImpl() {
		this.repoManager = new FacultyRepoManagerImpl();
	}
	*/

}
