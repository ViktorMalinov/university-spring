package main.dataaccess.speciality.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.common.Utils;
import main.dataaccess.common.PersistentRepoManagerImpl;
import main.dataaccess.speciality.dao.Speciality;

@Repository
public class SpecialityRepoManagerImpl extends PersistentRepoManagerImpl<Speciality> implements SpecialityRepoManager {

	//private static Map<Long, Speciality> datasource = new HashMap<Long, Speciality>();
	
	@Autowired
	private SpecialityCrudRepository datasource;


	@Override
	public CrudRepository<Speciality, Long> getDataSource() {
		return datasource;
	}
	
	
	public String getPath() {
        String file = Utils.getResourceFolder() + "\\datafiles\\Speciality.json"; 
		
		return file;
	}
	

	@Override
	public Class<?> getClazz() {
		return Speciality.class;
	}


}
