package main.service.apigroupuser;

import main.service.apigroup.ApiGroupParam;
import main.service.apigroup.ApiGroupResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.business.apigroupuser.processor.ApiGroupUserProcessor;
import main.service.common.BaseDtoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/apigroupuser")
public class ApiGroupUserServiceImpl 
		extends BaseDtoServiceImpl<
		ApiGroupUserParam,
		ApiGroupUserResult,
		ApiGroupUserProcessor,
		Long>
		implements ApiGroupUserService {


	@Override
	@GetMapping(value = "/{id:[0-9][0-9]*}", produces = "application/json")
	public ResponseEntity<ApiGroupUserResult> get(@PathVariable("id") Long id) throws Exception {
		return super.get(id);
	}

	@Override
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiGroupUserResult> create(@RequestBody ApiGroupUserParam param) throws Exception {
		return super.create(param);
	}

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<ApiGroupUserResult>> getAll() throws Exception {
		return super.getAll();
	}

	@Override
	@DeleteMapping("/delete/{id:[0-9][0-9]*}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@Override
	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Void> update(@RequestBody ApiGroupUserParam param) throws Exception {
		return super.update(param);
	}

}
