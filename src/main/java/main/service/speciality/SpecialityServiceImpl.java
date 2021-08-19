package main.service.speciality;

import main.service.discipline.DisciplineParam;
import main.service.discipline.DisciplineResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.business.speciality.processor.SpecialityProcessor;
import main.service.common.BaseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityServiceImpl 
		extends BaseServiceImpl<
		SpecialityParam,
		SpecialityResult,
		SpecialityProcessor,
		Long>
		implements SpecialityService {

	@Override
	@GetMapping(value = "/{id:[0-9][0-9]*}", produces = "application/json")
	public ResponseEntity<SpecialityResult> get(@PathVariable("id") Long id) throws Exception {
		return super.get(id);
	}

	@Override
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<SpecialityResult> create(@RequestBody SpecialityParam param) throws Exception {
		return super.create(param);
	}

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<SpecialityResult>> getAll() throws Exception {
		return super.getAll();
	}

	@Override
	@DeleteMapping("/delete/{id:[0-9][0-9]*}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@Override
	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Void> update(@RequestBody SpecialityParam param) throws Exception {
		return super.update(param);
	}


}
