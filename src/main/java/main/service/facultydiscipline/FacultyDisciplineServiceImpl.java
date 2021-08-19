package main.service.facultydiscipline;

import main.service.faculty.FacultyParam;
import main.service.faculty.FacultyResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.business.facultydiscipline.processor.FacultyDisciplineProcessor;
import main.service.common.BaseDtoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/facultydiscipline")
public class FacultyDisciplineServiceImpl 
		extends BaseDtoServiceImpl<
		FacultyDisciplineParam,
		FacultyDisciplineResult,
		FacultyDisciplineProcessor,
		Long>
implements FacultyDisciplineService {


	@Override
	@GetMapping(value = "/{id:[0-9][0-9]*}", produces = "application/json")
	public ResponseEntity<FacultyDisciplineResult> get(@PathVariable("id") Long id) throws Exception {
		return super.get(id);
	}

	@Override
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<FacultyDisciplineResult> create(@RequestBody FacultyDisciplineParam param) throws Exception {
		return super.create(param);
	}

	@Override
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<FacultyDisciplineResult>> getAll() throws Exception {
		return super.getAll();
	}

	@Override
	@DeleteMapping("/delete/{id:[0-9][0-9]*}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@Override
	@PutMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Void> update(@RequestBody FacultyDisciplineParam param) throws Exception {
		return super.update(param);
	}


}
