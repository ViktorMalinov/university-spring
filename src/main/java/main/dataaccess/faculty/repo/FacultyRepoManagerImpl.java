package main.dataaccess.faculty.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.common.Utils;
import main.dataaccess.common.PersistentRepoManagerImpl;
import main.dataaccess.faculty.dao.Faculty;

@Repository
public class FacultyRepoManagerImpl extends PersistentRepoManagerImpl<Faculty> implements FacultyRepoManager {

	//private static Map<Long, Faculty> datasource = new HashMap<Long, Faculty>();
	
	@Autowired
	private FacultyCrudRepository datasource;
	

	@Override
	public CrudRepository<Faculty, Long> getDataSource() {
		return datasource;
	}
	
	
	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\Faculty.json"; 
		
		return file;
	}
	
	@Override
	public Class<?> getClazz() {
		return Faculty.class;
	}


}
