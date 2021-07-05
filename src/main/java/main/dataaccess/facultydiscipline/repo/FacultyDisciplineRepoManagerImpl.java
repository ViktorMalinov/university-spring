package main.dataaccess.facultydiscipline.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import main.common.Utils;
import main.dataaccess.common.PersistentRepoManagerImpl;
import main.dataaccess.facultydiscipline.dao.FacultyDiscipline;

public class FacultyDisciplineRepoManagerImpl extends PersistentRepoManagerImpl<FacultyDiscipline> implements FacultyDisciplineRepoManager {

	//private static Map<Long, FacultyDiscipline> datasource = new HashMap<Long, FacultyDiscipline>();

	@Autowired
	private CrudRepository<FacultyDiscipline, Long> datasource;
	
	
	@Override
	public CrudRepository<FacultyDiscipline, Long> getDataSource() {
		return datasource;
	}

	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\FacultyDiscipline.json"; 
		
		return file;
	}
	
	@Override
	public Class<?> getClazz() {
		return FacultyDiscipline.class;
	}


}
