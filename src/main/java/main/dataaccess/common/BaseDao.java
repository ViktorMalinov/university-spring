package main.dataaccess.common;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseDao <PK, ENT> {

	ENT create(ENT entity);
	ENT get(PK id);
	void update(ENT entity);
	void delete(PK id);
	List<ENT> selectAll();

	List<ENT> find(String name, String value)
			throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, IntrospectionException, InvocationTargetException;

}
