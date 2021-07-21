package main.service.apiuser;

import lombok.*;
import main.service.common.NameDto;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApiUserResult extends NameDto{

	private String displayName;
	private String email;
	private String password;
	private String username;


}
