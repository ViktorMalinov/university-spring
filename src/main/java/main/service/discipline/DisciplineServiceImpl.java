package main.service.discipline;

import main.service.department.DepartmentParam;
import main.service.department.DepartmentResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.business.discipline.processor.DisciplineProcessor;
import main.service.common.BaseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineServiceImpl 
extends BaseServiceImpl<
		DisciplineParam,
		DisciplineResult,
		DisciplineProcessor,
		Long>
		implements DisciplineService {

	@Override
	@GetMapping(value = "/{id:[0-9][0-9]*}", produces = "application/json")
	public ResponseEntity<DisciplineResult> get(@PathVariable("id") Long id) throws Exception {
		return super.get(id);
	}

	@Override
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<DisciplineResult> create(@RequestBody DisciplineParam param) throws Exception {
		return super.create(param);
	}

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<DisciplineResult>> getAll() throws Exception {
		return super.getAll();
	}

	@Override
	@DeleteMapping("/delete/{id:[0-9][0-9]*}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@Override
	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Void> update(@RequestBody DisciplineParam param) throws Exception {
		return super.update(param);
	}


}
