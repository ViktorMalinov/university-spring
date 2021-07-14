package main.dataaccess.lecturer.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.common.BaseDaoImpl;
import main.dataaccess.lecturer.repo.LecturerRepoManager;

@Component
public class LecturerDaoImpl extends BaseDaoImpl <Long, Lecturer, LecturerRepoManager> implements LecturerDao {
	
	/*
	public LecturerDaoImpl() {
		this.repoManager = new LecturerRepoManagerImpl();
	}
	*/

}
