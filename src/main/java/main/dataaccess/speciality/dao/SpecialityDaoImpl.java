package main.dataaccess.speciality.dao;

import org.springframework.stereotype.Component;

import main.dataaccess.common.BaseDaoImpl;
import main.dataaccess.speciality.repo.SpecialityRepoManager;

@Component
public class SpecialityDaoImpl extends BaseDaoImpl <Long, Speciality, SpecialityRepoManager> implements SpecialityDao {
	
	/*
	public SpecialityDaoImpl() {
		this.repoManager = new SpecialityRepoManagerImpl();
	}
	*/
	
}
