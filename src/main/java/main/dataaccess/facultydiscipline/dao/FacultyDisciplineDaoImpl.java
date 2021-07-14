package main.dataaccess.facultydiscipline.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.common.BaseDaoImpl;
import main.dataaccess.facultydiscipline.repo.FacultyDisciplineRepoManager;

@Component
public class FacultyDisciplineDaoImpl extends BaseDaoImpl <Long, FacultyDiscipline, FacultyDisciplineRepoManager> implements FacultyDisciplineDao {
	
	/*
	public FacultyDisciplineDaoImpl() {
		this.repoManager = new FacultyDisciplineRepoManagerImpl();
	}
	*/
}
