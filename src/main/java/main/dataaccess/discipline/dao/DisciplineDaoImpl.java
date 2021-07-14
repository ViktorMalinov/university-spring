package main.dataaccess.discipline.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.common.BaseDaoImpl;
import main.dataaccess.discipline.repo.DisciplineRepoManager;

@Component
public class DisciplineDaoImpl extends BaseDaoImpl <Long, Discipline, DisciplineRepoManager> implements DisciplineDao {

	/*
	public DisciplineDaoImpl() {
		this.repoManager = new DisciplineRepoManagerImpl();
	}
	*/
	
}
