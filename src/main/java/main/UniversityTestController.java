package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.service.apigroup.ApiGroupParam;
import main.service.apigroup.ApiGroupResult;
import main.service.apigroup.ApiGroupService;
import main.service.apiuser.ApiUserParam;
import main.service.apiuser.ApiUserResult;
import main.service.apiuser.ApiUserService;


@RestController
@RequestMapping("uni")
public class UniversityTestController {

	@Autowired
	private ApiGroupService apiGroupService;
	
	@Autowired
	private ApiUserService apiUser;
	
	@GetMapping("test")
	public String getTestMessage() throws Exception  {
		//System.out.print("Test Test");
		apiGroupTest();
		//ApiUserTest();
		
		
		return "Test Test";
		
	}

	@GetMapping("apigroupgetall")
	public List<ApiGroupResult> getAllArticles() throws Exception {
		List<ApiGroupResult> list = apiGroupService.getAll();
		return list;
		
	}
	
	@GetMapping("/apigroupbyid/{id}")
	public ApiGroupResult getAPiGroupById(@PathVariable(value = "id") String id) throws Exception {
		ApiGroupResult result = apiGroupService.get((Long.valueOf(id)));
		return result;
		
	}

// --------------------- TEST FUNCTIONS ---------------------------------------	
	
	public void apiGroupTest() throws Exception {
		ApiGroupParam param = new ApiGroupParam();
		
		
		System.out.println("------ ApiGroup TEST ----------");
		// create
		//param.setId(id);
		param.setCode(10L);
		param.setName("Group 1");
		param.setDescription("First group ever... :)");
		param.setDisplayName("Display Name AG");
		//apiGroup.create(null);
		apiGroupService.create(param);

		param.setCode(20L);
		param.setName("Group 2");
		param.setDescription("Secong group ever... :)");
		param.setDisplayName("Display Name AG - 2");
		apiGroupService.create(param);

		param.setCode(30L);
		param.setName("Group 3");
		param.setDescription("Last group ever... :)");
		param.setDisplayName("Display Name AG-3");
		apiGroupService.create(param);
		
		
		// get
		ApiGroupResult res =  apiGroupService.get(1L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s , displayName: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription(), res.getDisplayName());
		
		res =  apiGroupService.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s , displayName: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription(), res.getDisplayName());
		
		// update
		param.setId(res.getId());
		param.setDescription("Secong group ever... :) - a");
		param.setCode(21L);
		param.setName("Group 2a");
		param.setDisplayName("Display Name AG - 2a");
		
		apiGroupService.update(param);
		
		res =  apiGroupService.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s , displayName: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription(), res.getDisplayName());
		
		// delete
		//apiGroupService.delete(3L); // deleting group 
		//System.out.println("id: 3 was deleted...");
		
		System.out.println();
		System.out.println();
	}
	
	
	public void ApiUserTest()  throws Exception{
		 
		ApiUserParam param = new ApiUserParam();
		
		
		System.out.println("------ ApiUser TEST ----------");
		// create
		//param.setId(id);
		param.setCode(10L);
		param.setDisplayName("Group 1");
		param.setDescription("First group ever... :)");
		param.setName("name - 1");
		param.setUsername("Username - 1");
		param.setEmail("e-mail - 1");
		param.setPassword("************");
		apiUser.create(param);

		param.setCode(20L);
		param.setDisplayName("Group 2");
		param.setDescription("Secong group ever... :)");
		param.setName("name - 2");
		param.setUsername("Username - 2");
		param.setEmail("e-mail - 2");
		param.setPassword("################");
		apiUser.create(param);

		
		// get
		ApiUserResult res =  apiUser.get(1L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getDisplayName(), res.getDescription());
		
		res =  apiUser.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getDisplayName(), res.getDescription());
		
		// update
		param.setId(res.getId());
		param.setDescription(res.getDescription());
		param.setCode(21L);
		param.setDisplayName("Group 2a");
		apiUser.update(param);
		res =  apiUser.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getDisplayName(), res.getDescription());
		
	}
	
	
	
	
	
	
	
	
}
