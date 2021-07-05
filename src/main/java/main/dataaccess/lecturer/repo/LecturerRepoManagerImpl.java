package main.dataaccess.lecturer.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import main.common.Utils;
import main.dataaccess.common.PersistentRepoManagerImpl;
import main.dataaccess.lecturer.dao.Lecturer;

public class LecturerRepoManagerImpl extends PersistentRepoManagerImpl<Lecturer> implements LecturerRepoManager {

	//private static Map<Long, Lecturer> datasource = new HashMap<Long, Lecturer>();
	
	@Autowired
	private CrudRepository<Lecturer, Long> datasource;
	

	@Override
	public CrudRepository<Lecturer, Long> getDataSource() {
		return datasource;
	}

	
	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\Lecturer.json"; 
		
		return file;
	}
	
	@Override
	public Class<?> getClazz() {
		return Lecturer.class;
	}


}
