package main.service.common;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseService<IN, OUT, PK> {

	ResponseEntity<OUT> create(IN param) throws Exception;
	ResponseEntity<OUT> get(PK id) throws Exception;
	ResponseEntity<Void> update(IN param) throws Exception;
	ResponseEntity<Void> delete(PK id);
	ResponseEntity<List<OUT>> getAll() throws Exception;

}
