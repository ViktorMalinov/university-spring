package main.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.business.common.BaseProcessor;
import org.springframework.http.ResponseEntity;

public class BaseDtoServiceImpl<
		IN  extends BaseDto,
		OUT extends BaseDto,
		PRC extends BaseProcessor<IN, OUT, PK>,
		PK> 
		implements BaseService<IN, OUT, PK> {
	
	@Autowired
	protected PRC processor;

	//  @PostMapping
	@Override
	public ResponseEntity<OUT> create(IN param) throws Exception {
		OUT result;
		
		result = processor.create(param);

		return ResponseEntity.ok(result);
	}

	//@GetMapping("/{id:[0-9][0-9]*}")
	@Override
	public ResponseEntity<OUT> get(PK id)  throws Exception {
		OUT result = processor.get(id);
		return ResponseEntity.ok(result);
	}

	//  @PutMapping
	@Override
	public ResponseEntity<Void> update(IN param)  throws Exception {
		processor.update(param);
		return ResponseEntity.noContent().build();
	}

	//  @DeleteMapping("erase/{id:[0-9][0-9]*}")
	@Override
	public ResponseEntity<Void> delete(PK id) {
		processor.delete(id);
		return ResponseEntity.noContent().build();
	}


	//@GetMapping
	@Override
	public ResponseEntity<List<OUT>> getAll() throws Exception {
		return ResponseEntity.ok(processor.getAll());
	}	

}
