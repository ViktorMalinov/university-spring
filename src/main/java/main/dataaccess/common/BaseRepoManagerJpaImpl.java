package main.dataaccess.common;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public abstract class BaseRepoManagerJpaImpl<PK, ENT> implements BaseRepoManager<PK, ENT> {

	
	protected abstract CrudRepository<ENT, PK> getDataSource();
	
	@Override
	public ENT insert(ENT entity) {
		ENT result;
		
		result = getDataSource().save(entity);
		return result;
	}

	@Override
	public ENT select(PK id) {
		ENT result = null;
		
		result = getDataSource().findById(id).orElse(result);
		
		return result;
	}

	@Override
	public void update(ENT entity) {
		getDataSource().save(entity);
	}

	@Override
	public void delete(PK id) {
		getDataSource().deleteById(id);
	}

	@Override
	public List<ENT> selectAll() {
		Iterable <ENT> result; 
		result = getDataSource().findAll();
		
		return null;
		
	}

}
