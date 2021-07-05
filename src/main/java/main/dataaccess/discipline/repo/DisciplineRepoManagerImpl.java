package main.dataaccess.discipline.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import main.common.Utils;
import main.dataaccess.common.PersistentRepoManagerImpl;
import main.dataaccess.discipline.dao.Discipline;

public class DisciplineRepoManagerImpl extends PersistentRepoManagerImpl<Discipline> implements DisciplineRepoManager {

	//private static Map<Long, Discipline> datasource = new HashMap<Long, Discipline>();
	
	@Autowired
	private CrudRepository<Discipline, Long> datasource;
	

	@Override
	public CrudRepository<Discipline, Long> getDataSource() {
		return datasource;
	}

	
	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\Discipline.json"; 
		
		return file;

	}
	
	@Override
	public Class<?> getClazz() {
		return Discipline.class;
	}


}
