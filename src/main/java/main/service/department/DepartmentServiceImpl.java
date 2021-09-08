package main.service.department;

import main.service.apiuser.ApiUserParam;
import main.service.apiuser.ApiUserResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.business.department.processor.DepartmentProcessor;
import main.service.common.BaseServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentServiceImpl 
		extends BaseServiceImpl<
		DepartmentParam,
		DepartmentResult,
		DepartmentProcessor,
		Long>
		implements DepartmentService {


	@Override
	@GetMapping(value = "/{id:[0-9][0-9]*}", produces = "application/json")
	public ResponseEntity<DepartmentResult> get(@PathVariable("id") Long id) throws Exception {
		return super.get(id);
	}

	@Override
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<DepartmentResult> create(@RequestBody DepartmentParam param) throws Exception {
		return super.create(param);
	}

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<DepartmentResult>> getAll() throws Exception {
		return super.getAll();
	}

	@Override
	@DeleteMapping("/delete/{id:[0-9][0-9]*}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@Override
	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Void> update(@RequestBody DepartmentParam param) throws Exception {
		return super.update(param);
	}




	
}
