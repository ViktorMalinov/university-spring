package main.dataaccess.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl <PK, ENT, MAN extends BaseRepoManager<PK,ENT>> implements BaseDao <PK, ENT> {

	@Autowired
	protected MAN repoManager;
	
	@Override
	public ENT create(ENT entity) {
		ENT res = repoManager.insert(entity);
		return res;
	}

	@Override
	public ENT get(PK id) {
		ENT entity = repoManager.select(id);
		return entity;	
	}

	@Override
	public void update(ENT entity) {
		repoManager.update(entity);
	}

	@Override
	public void delete(PK id) {
		repoManager.delete(id);

	}
	
	@Override
	public List<ENT> selectAll() {
		List<ENT> allData = repoManager.selectAll();
		return allData;
	}
	
	
}
