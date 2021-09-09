package main.service.apisession;

import main.business.apisession.processor.ApiSessionProcessor;
import main.business.apiuser.processor.ApiUserProcessor;
import main.service.common.BaseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apisession")
public class ApiSessionServiceImpl
extends BaseServiceImpl<
        ApiSessionParam,
        ApiSessionResult,
        ApiSessionProcessor,
Long>
implements ApiSessionService {

    @Override
    @GetMapping(value = "/{id:[0-9][0-9]*}", produces = "application/json")
    public ResponseEntity<ApiSessionResult> get(@PathVariable("id") Long id) throws Exception {
        return super.get(id);
    }

    @Override
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiSessionResult> create(@RequestBody ApiSessionParam param) throws Exception {
        return super.create(param);
    }

    @Override
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ApiSessionResult>> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    @DeleteMapping("/delete/{id:[0-9][0-9]*}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @Override
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> update(@RequestBody ApiSessionParam param) throws Exception {
        return super.update(param);
    }

}
