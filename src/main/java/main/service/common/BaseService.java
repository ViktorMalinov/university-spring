package main.service.common;

import java.util.List;

public interface BaseService<IN, OUT, PK> {

	OUT create(IN param) throws Exception;
	OUT get(PK id) throws Exception;
	void update(IN param) throws Exception;
	void delete(PK id);
	List<OUT> getAll() throws Exception;

}
