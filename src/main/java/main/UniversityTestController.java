package main;

import main.business.apigroup.processor.ApiGroupProcessor;
import main.business.apigroupuser.processor.ApiGroupUserProcessor;
import main.business.apiuser.processor.ApiUserProcessor;
import main.service.apigroup.ApiGroupResult;
import main.service.apigroup.ApiGroupService;
import main.service.apigroupuser.ApiGroupUserResult;
import main.service.apigroupuser.ApiGroupUserService;
import main.service.apiuser.ApiUserResult;
import main.service.apiuser.ApiUserService;
import main.service.department.DepartmentService;
import main.service.discipline.DisciplineService;
import main.service.faculty.FacultyService;
import main.service.facultydiscipline.FacultyDisciplineService;
import main.service.lecturer.LecturerService;
import main.service.speciality.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@RequestMapping("/uni")
public class UniversityTestController {

	@Autowired
	private ApiGroupService apiGroupService;
	@Autowired
	private ApiUserService apiUser;
	@Autowired
	private ApiGroupUserService apiGroupUser;
	@Autowired
	private FacultyService Faculty;
	@Autowired
	private DepartmentService Department; 
	@Autowired
	private DisciplineService Discipline;
	@Autowired
	private FacultyDisciplineService FacultyDiscipline;
	@Autowired
	private LecturerService Lecturer;
	@Autowired
	private SpecialityService Speciality;

	@Autowired
	ApiUserProcessor apiUserProc;
	@Autowired
	ApiGroupProcessor apiGroupProc;
	@Autowired
	ApiGroupUserProcessor apiGroupUserProc;

	
	
	/*
	@GetMapping("test")
	public String getTestMessage() throws Exception  {
		//System.out.print("Test Test");
		
	try {
		apiGroupTest();
		ApiUserTest();
		apiGroupUserTest();
		FacultyTest();
	    DepartmentTest();
	    DisciplineTest();
	    FacultyDisciplineTest();
	    LecturerTest(); 
	    SpecialityTest();
	}
	catch (Exception e) {
		System.out.print(e.getMessage());
		return e.getMessage();
	}

		return "Test Test";
		
	}

	*/

	@GetMapping("username")
	public String currentUserName(Authentication authentication) {

		return "Username: " + authentication.getName();
	}


	@GetMapping("/username/{userName}")
	public ApiUserResult getAPiUserByName(@PathVariable(value = "userName") String userName) throws Exception {
		ApiUserResult res = new ApiUserResult();

		List<ApiUserResult> result =  apiUserProc.getAll();

		res = result.stream()
				.filter(user -> userName.equals(user.getUsername()))
				.findFirst().orElse(res);

		return res;

	}

	@GetMapping("apigroupgetall")
	public List<ApiGroupResult> getAllArticles() throws Exception {
		List<ApiGroupResult> list =  apiGroupProc.getAll();
		return list;
		
	}
	
	@GetMapping("/apigroupbyid/{id}")
	public ApiGroupResult getAPiGroupById(@PathVariable(value = "id") String id) throws Exception {
		ApiGroupResult result = apiGroupProc.get((Long.valueOf(id)));
		return result;
		
	}

	@GetMapping("/ug/{id}")
	public String getRolesForUser(@PathVariable(value = "id") String sid) throws Exception {
		Long id = Long.valueOf(sid);
		String roles = "";

		List<ApiGroupUserResult>  grpUser =  apiGroupUserProc.getAll();
		List<ApiGroupResult>  groups =  apiGroupProc.getAll();

		Stream<ApiGroupUserResult> fltUserGroups = grpUser.stream().filter(gu -> gu.getApiUserId().equals(id));
		List<ApiGroupUserResult> fltUserGroupsList = fltUserGroups.collect(Collectors.toList());

		Stream<ApiGroupResult> fltGroups = groups.stream().filter(
						g -> fltUserGroupsList.stream().anyMatch(gu -> gu.getApiGroupId().equals(g.getId()))
						//g -> checkGroup(fltUserGroupsList,g.getId())
						//g -> g.getId() == 2 || g.getId() == 1
		);

		List<ApiGroupResult> fltGroupsList = fltGroups.collect(Collectors.toList());

		for (ApiGroupResult apiG : fltGroupsList)
		{
			if (roles.equals(""))
				roles = apiG.getName();
			else
				roles = roles + "," +apiG.getName();
		}

		return roles;
	}

	private boolean checkGroup(List<ApiGroupUserResult> fltUserGroups, Long id) {
		boolean result = true;
		result = fltUserGroups.stream().anyMatch(gu -> gu.getApiGroupId() == id);
		return result;
	}

/*
// --------------------- TEST FUNCTIONS ---------------------------------------	
	
	public void apiGroupTest() throws Exception {
		ApiGroupParam param = new ApiGroupParam();
		
		
		System.out.println("------ ApiGroup TEST ----------");
		// create
		//param.setId(id);

		param.setCode(10L);
		param.setName("ADMIN");
		param.setDescription("First group ever... :)");
		param.setDisplayName("Display Name AG");
		
		//apiGroupService.create(null); // test
		
		apiGroupService.create(param);

		param.setCode(20L);
		param.setName("USERS");
		param.setDescription("Secong group ever... :)");
		param.setDisplayName("Display Name AG - 2");
		apiGroupService.create(param);

		param.setCode(30L);
		param.setName("USERS2");
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
		param.setName("USERS");
		param.setDisplayName("Display Name AG - 2a");
		
		apiGroupService.update(param);
		//apiGroupService.update(param);
		
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
		param.setDisplayName("Admin user");
		param.setDescription("First group ever... :)");
		param.setName("Atanas");
		param.setUsername("admin");
		param.setEmail("admin@xaos.com");
		param.setPassword("admin123");
		apiUser.create(param);

		param.setCode(20L);
		param.setDisplayName("Simple user");
		param.setDescription("Secong group ever... :)");
		param.setName("Ivan");
		param.setUsername("user");
		param.setEmail("user@xaos.com");
		param.setPassword("user123");
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
		param.setDisplayName("Simple user - modified");
		apiUser.update(param);
		res =  apiUser.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getDisplayName(), res.getDescription());
		
	}
	
	//-------------------------------------------------
	public void apiGroupUserTest()  throws Exception {
		ApiGroupUserParam param = new ApiGroupUserParam();
		
		
		System.out.println("------ ApiGroupUser TEST ----------");
		// create
		//param.setId(id);
		
		param.setApiGroupId(1L);
		param.setApiUserId(1L);
		apiGroupUser.create(param);

		param.setApiGroupId(2L);
		param.setApiUserId(2L);
		apiGroupUser.create(param);

		
		// get
		ApiGroupUserResult res =  apiGroupUser.get(1L);
		System.out.printf("id: %d, Groupid: %d, user id: %d%n", res.getId(), res.getApiGroupId(), res.getApiUserId());
		
		res =  apiGroupUser.get(2L);
		System.out.printf("id: %d, Groupid: %d, user id: %d%n", res.getId(), res.getApiGroupId(), res.getApiUserId());

		System.out.println();
		System.out.println();
	}

	public void FacultyTest() throws Exception {
		 
		FacultyParam param = new FacultyParam();
		
		
		System.out.println("------ Faculty TEST ----------");
		// create
		//param.setId(id);
		param.setCode(10L);
		param.setName("Group 1");
		param.setDescription("First group ever... :)");
		Faculty.create(param);

		param.setCode(20L);
		param.setName("Group 2");
		param.setDescription("Secong group ever... :)");
		Faculty.create(param);

		param.setCode(30L);
		param.setName("Group 3");
		param.setDescription("Last group ever... :)");
		Faculty.create(param);
		
		// get
		FacultyResult res =  Faculty.get(1L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		res =  Faculty.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		// update
		param.setId(res.getId());
		param.setDescription(res.getDescription());
		param.setCode(21L);
		param.setName("Group 2a");
		Faculty.update(param);
		res =  Faculty.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		// delete
		//Faculty.delete(3L); // deleting group 
		//System.out.println("id: 3 was deleted...");
		
		System.out.println();
		System.out.println();
	}
	
	public void DepartmentTest() throws Exception {
		DepartmentParam param = new DepartmentParam();
		
		
		System.out.println("------ Department TEST ----------");
		// create
		//param.setId(id);
		param.setCode(10L);
		param.setName("Group 1");
		param.setDescription("First group ever... :)");
		param.setFacultyId(1L);
		Department.create(param);

		param.setCode(20L);
		param.setName("Group 2");
		param.setDescription("Secong group ever... :)");
		param.setFacultyId(2L);
		Department.create(param);

		
		// get
		DepartmentResult res =  Department.get(1L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s, facultyID: %d %n", res.getId(), res.getCode(), res.getName(), res.getDescription(), res.getFacultyId());
		
		res =  Department.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s, facultyID: %d %n", res.getId(), res.getCode(), res.getName(), res.getDescription(), res.getFacultyId());
		
		// update
		param.setId(res.getId());
		param.setDescription(res.getDescription());
		param.setCode(21L);
		param.setName("Group 2a");
		param.setFacultyId(2L);
		Department.update(param);
		res =  Department.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s, facultyID: %d %n", res.getId(), res.getCode(), res.getName(), res.getDescription(), res.getFacultyId());
		
	
		System.out.println();
		System.out.println();
	}
	
	
	public void DisciplineTest() throws Exception {
		DisciplineParam param = new DisciplineParam();
		
		
		System.out.println("------ Discipline TEST ----------");
		// create
		//param.setId(id);
		param.setCode(10L);
		param.setName("Group 1");
		param.setDescription("First group ever... :)");
		Discipline.create(param);

		param.setCode(20L);
		param.setName("Group 2");
		param.setDescription("Secong group ever... :)");
		Discipline.create(param);

		param.setCode(30L);
		param.setName("Group 3");
		param.setDescription("Last group ever... :)");
		Discipline.create(param);
		
		// get
		DisciplineResult res =  Discipline.get(1L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		res =  Discipline.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		// update
		param.setId(res.getId());
		param.setDescription(res.getDescription());
		param.setCode(21L);
		param.setName("Group 2a");
		Discipline.update(param);
		res =  Discipline.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		// delete
		//Discipline.delete(3L); // deleting group 
		//System.out.println("id: 3 was deleted...");
		
		System.out.println();
		System.out.println();
	}
	

	public  void FacultyDisciplineTest() throws Exception {
		FacultyDisciplineParam param = new FacultyDisciplineParam();
		
		
		System.out.println("------ FacultyDiscipline TEST ----------");
		// create
		//param.setId(id);
		param.setDisciplineId(1L);
		param.setFacultyId(1L);
		FacultyDiscipline.create(param);

		param.setDisciplineId(2L);
		param.setFacultyId(2L);
		FacultyDiscipline.create(param);


		
		// get
		FacultyDisciplineResult res =  FacultyDiscipline.get(1L);
		System.out.printf("id: %d, FacultyID: %d, description ID: %d%n", res.getId(), res.getFacultyId(), res.getDisciplineId());
		
		res =  FacultyDiscipline.get(2L);
		System.out.printf("id: %d, FacultyID: %d, description ID: %d%n", res.getId(), res.getFacultyId(), res.getDisciplineId());
		
		// update
		param.setId(res.getId());
		param.setFacultyId(1L);
		FacultyDiscipline.update(param);
		res =  FacultyDiscipline.get(2L);
		System.out.printf("id: %d, FacultyID: %d, description ID: %d%n", res.getId(), res.getFacultyId(), res.getDisciplineId());
		
		System.out.println();
		System.out.println();
	}
	
	
	public  void LecturerTest() throws Exception {
		LecturerParam param = new LecturerParam();
		
		
		System.out.println("------ Lecturer TEST ----------");
		// create
		//param.setId(id);
		param.setCode(10L);
		param.setName("Group 1");
		param.setDescription("First group ever... :)");
		param.setFamilyName("Family name - 1");
		param.setDepartmentId(1L);
		param.setApiUserId(1L);
		Lecturer.create(param);

		param.setCode(20L);
		param.setName("Group 2");
		param.setDescription("Secong group ever... :)");
		param.setFamilyName("Family name - 2");
		param.setDepartmentId(2L);
		param.setApiUserId(2L);
		Lecturer.create(param);

		
		// get
		LecturerResult res =  Lecturer.get(1L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		res =  Lecturer.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		// update
		param.setId(res.getId());
		param.setDescription(res.getDescription());
		param.setCode(21L);
		param.setName("Group 2a");
		Lecturer.update(param);
		res =  Lecturer.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		
		System.out.println();
		System.out.println();
	}
	
	public void SpecialityTest() throws Exception {
		SpecialityParam param = new SpecialityParam();
		
		
		System.out.println("------ Speciality TEST ----------");
		// create
		//param.setId(id);
		param.setCode(10L);
		param.setName("Group 1");
		param.setDescription("First group ever... :)");
		param.setFacultyId(2L);
		Speciality.create(param);

		param.setCode(20L);
		param.setName("Group 2");
		param.setDescription("Secong group ever... :)");
		param.setFacultyId(1L);
		Speciality.create(param);

		param.setCode(30L);
		param.setName("Group 3");
		param.setFacultyId(1L);
		param.setDescription("Last group ever... :)");
		Speciality.create(param);
		
		// get
		SpecialityResult res =  Speciality.get(1L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		res =  Speciality.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		// update
		param.setId(res.getId());
		param.setDescription(res.getDescription());
		param.setCode(21L);
		param.setName("Group 2a");
		Speciality.update(param);
		res =  Speciality.get(2L);
		System.out.printf("id: %d, code: %d, name: %s, description: %s%n", res.getId(), res.getCode(), res.getName(), res.getDescription());
		
		
		System.out.println();
		System.out.println();
	}
	*/
	
	
	
}
