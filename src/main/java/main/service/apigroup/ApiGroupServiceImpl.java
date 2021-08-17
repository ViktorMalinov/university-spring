package main.service.apigroup;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.business.apigroup.processor.ApiGroupProcessor;
import main.service.common.BaseServiceImpl;

import java.util.List;

@RestController
//@RequestMapping(value = "/apigroup", produces = "application/json", consumes = "application/json")
@RequestMapping("/apigroup")
public class ApiGroupServiceImpl 
extends BaseServiceImpl<
		ApiGroupParam,
		ApiGroupResult,
		ApiGroupProcessor,
		Long>
		implements ApiGroupService {

	@Override
	@GetMapping("/{id:[0-9][0-9]*}")
	public ResponseEntity<ApiGroupResult> get(@PathVariable("id") Long id) throws Exception {
		return super.get(id);
	}

	@Override
	@PostMapping
	public ResponseEntity<ApiGroupResult> create(@RequestBody ApiGroupParam param) throws Exception {
		return super.create(param);
	}

	@Override
	@GetMapping
	public ResponseEntity<List<ApiGroupResult>> getAll() throws Exception {
		return super.getAll();
	}
}
