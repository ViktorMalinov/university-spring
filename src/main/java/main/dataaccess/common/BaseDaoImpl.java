package main.dataaccess.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList;
import static org.apache.commons.lang3.reflect.FieldUtils.readDeclaredField;

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

	@Override
	public List<ENT> find(String name, String value) {
		ArrayList<ENT> entities = new ArrayList<>();
		selectAll().forEach(ent -> {
			for (Field field : getAllFieldsList(ent.getClass())) {
				field.setAccessible(true);
				String fieldValue = null;
				try {
					fieldValue = (String) readDeclaredField(ent, name, true);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (field.getName().equals(name) && value.equals(fieldValue)) {
					entities.add(ent);
				}
			}
		});
		return entities;
	}


	
}
