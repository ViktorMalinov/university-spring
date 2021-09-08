package main.service.apiuser;

import main.service.apigroupuser.ApiGroupUserParam;
import main.service.apigroupuser.ApiGroupUserResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.business.apiuser.processor.ApiUserProcessor;
import main.service.common.BaseServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/apiuser")
public class ApiUserServiceImpl 
extends BaseServiceImpl<
ApiUserParam,
ApiUserResult,
ApiUserProcessor,
Long>
implements ApiUserService {

    @Override
    @GetMapping(value = "/{id:[0-9][0-9]*}", produces = "application/json")
    public ResponseEntity<ApiUserResult> get(@PathVariable("id") Long id) throws Exception {
        return super.get(id);
    }

    @Override
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiUserResult> create(@RequestBody ApiUserParam param) throws Exception {
        return super.create(param);
    }

    @Override
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ApiUserResult>> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    @DeleteMapping("/delete/{id:[0-9][0-9]*}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }

    @Override
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void> update(@RequestBody ApiUserParam param) throws Exception {
        return super.update(param);
    }

}
